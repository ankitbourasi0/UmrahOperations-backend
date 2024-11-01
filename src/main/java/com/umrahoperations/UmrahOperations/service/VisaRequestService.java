package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.dto.TravellerDTO;
import com.umrahoperations.UmrahOperations.dto.VisaRequestDTO;
import com.umrahoperations.UmrahOperations.model.Traveller;
import com.umrahoperations.UmrahOperations.model.VisaRequest;
import com.umrahoperations.UmrahOperations.repository.TravellerRepository;
import com.umrahoperations.UmrahOperations.repository.VisaRequestRepository;
import com.umrahoperations.UmrahOperations.utils.InsufficientWalletBalanceException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@Slf4j
public class VisaRequestService {

    private final VisaRequestRepository visaRequestRepository;
    private final TravellerRepository travellerRepository;

    private static final Logger logger = LoggerFactory.getLogger(VisaRequestService.class);

    @Autowired
    public VisaRequestService(VisaRequestRepository visaRequestRepository,
                              TravellerRepository travellerRepository) {
        this.visaRequestRepository = visaRequestRepository;
        this.travellerRepository = travellerRepository;
    }

    public VisaRequest  createVisaRequest(VisaRequestDTO requestDTO) {
        try {
            // Validate total amount before proceeding
            BigDecimal totalAmount = calculateTotalAmount(requestDTO);

            // Create new visa request
            VisaRequest visaRequest = new VisaRequest();

            // Set the fields
            visaRequest.setVrDate(requestDTO.getRequestDate());
            visaRequest.setVrAgentCode(requestDTO.getAgentCode());
            visaRequest.setVrVisaPriceId(requestDTO.getVisaPriceId());
            visaRequest.setVrSourceCurrency(requestDTO.getSourceCurrency());
            visaRequest.setVrAgentCurrency(requestDTO.getAgentCurrency());
            visaRequest.setVrCurrencyRate(requestDTO.getCurrencyRate());
            visaRequest.setVrTotalPax(requestDTO.getTravellers().size());
            visaRequest.setVrStatus(1);
            visaRequest.setVruserId(requestDTO.getVruserId());
            visaRequest.setVrToken(requestDTO.getToken());
            visaRequest.setVrEdate(LocalDate.now());
            visaRequest.setVrSupplierId(requestDTO.getSupplierId());
            visaRequest.setVrTotalSourceAmount(totalAmount);
            visaRequest.setVrTotalAgentAmount(totalAmount.multiply(requestDTO.getCurrencyRate())
                    .setScale(2, RoundingMode.HALF_UP));

            /*
            VisaRequestDTO(
            visaPriceId=1000022, requestDate=2024-10-27,
            agentCode=20005561, token=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXBwb3J0QG1ha2V5b3VyYm9va2luZy5pbiIsImNvdW50cnlDb2RlIjo5MSwiaWF0IjoxNzMwMDE4Mzk3LCJleHAiOjE3MzAwNTQzOTd9.VLChCPxHg5XPx6pVTvOmoWVL6IVEBEd22w00-FDbBYI,
            vruserId=1388, sourceCurrency=966,
            agentCurrency=91, currencyRate=22.3,
            supplierId=20005541, travellers=[
                    TravellerDTO(title=1, firstName=Ankkit,
                    lastName=Java, passportNo=0105102151,
                    dateOfBirth=2024-10-01, passportExpiry=2024-10-31,
                    adultPrice=550, childPrice=550, infantPrice=550)])
            */
            // Save the visa request
            VisaRequest savedVisaRequest;
            try {
                savedVisaRequest = visaRequestRepository.save(visaRequest);
                logger.info("Visa request saved: " + savedVisaRequest.toString());
            } catch (Exception e) {
                if (e.getCause() != null && e.getCause().getCause() != null
                        && e.getCause().getCause().getMessage().contains("ORA-01403")) {
                    throw new InsufficientWalletBalanceException(
                            "Insufficient wallet balance for agent: " + requestDTO.getAgentCode());
                }
                throw e;
            }

            // Create and save travellers
            List<Traveller> travellers = new ArrayList<>();
            for (TravellerDTO travellerDTO : requestDTO.getTravellers()) {
                Traveller traveller = mapTravellerDTOToEntity(travellerDTO, savedVisaRequest.getVrId(), requestDTO);
                travellers.add(traveller);
            }

            travellerRepository.saveAll(travellers);
            logger.info( "Travellers Details "+ travellers.toString());

            return savedVisaRequest;

        } catch (InsufficientWalletBalanceException e) {
            log.error("Insufficient wallet balance", e);
            throw e;
        } catch (Exception e) {
            log.error("Error creating visa request", e);
            throw new RuntimeException("Failed to create visa request", e);
        }
    }

    private Traveller mapTravellerDTOToEntity(TravellerDTO dto, Long visaRequestId, VisaRequestDTO requestDTO) {
        Traveller traveller = new Traveller();
        traveller.setMtVisaRequest(visaRequestId);
        traveller.setMtTitle(dto.getTitle());
        traveller.setMtFirstName(dto.getFirstName());
        traveller.setMtLastName(dto.getLastName());
        traveller.setMtPassport(dto.getPassportNo());
        traveller.setMtDob(dto.getDateOfBirth());
        traveller.setMtExpiryDate(dto.getPassportExpiry());
        traveller.setMtStatus(1);
        traveller.setMtSourceCurrency(requestDTO.getSourceCurrency());
        traveller.setMtAgentCurrency(requestDTO.getAgentCurrency());
        traveller.setMtEaCode(requestDTO.getAgentCode());
        traveller.setMtAdultPrice(dto.getAdultPrice());
        traveller.setMtChildPrice(dto.getChildPrice());
        traveller.setMtInfantPrice(dto.getInfantPrice());

        // Calculate age and set appropriate price
        Integer age = calculateAge(dto.getDateOfBirth());
        traveller.setMtAge(age); // Assuming you have this field in your Traveller entity


//        traveller.setMtNationality(dto.getNationality());
        traveller.setMtEdate(LocalDate.now());
        return traveller;

    }

    private Integer calculateAge(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("Date of birth cannot be null");
        }

        LocalDate currentDate = LocalDate.now();

        // Check if date of birth is in the future
        if (dateOfBirth.isAfter(currentDate)) {
            throw new IllegalArgumentException("Date of birth cannot be in the future");
        }

        int age = currentDate.getYear() - dateOfBirth.getYear();

        // Adjust age if birthday hasn't occurred this year
        if (currentDate.getMonthValue() < dateOfBirth.getMonthValue() ||
                (currentDate.getMonthValue() == dateOfBirth.getMonthValue() &&
                        currentDate.getDayOfMonth() < dateOfBirth.getDayOfMonth())) {
            age--;
        }

        return age;
    }

    private BigDecimal calculateTotalAmount(VisaRequestDTO requestDTO) {
        return requestDTO.getTravellers().stream()
                .map(t -> t.getAdultPrice()) // Assuming adult price for now
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public boolean deleteVisaRequest(Long vrId)
    {
    	VisaRequest v = new VisaRequest();
    	v.setVrId(vrId);
    	visaRequestRepository.delete(v);
    	return true;
    	
    }
    public boolean updateVisaStatus(VisaRequestDTO visa)
    {
    	
    	visaRequestRepository.updateVisaRequestStatus(visa.getVisaStatus(),visa.getVrId());
    	return true;
    	
    }
}