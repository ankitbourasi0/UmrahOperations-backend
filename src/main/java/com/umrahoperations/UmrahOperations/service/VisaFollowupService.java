package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.dto.VisaFollowupDTO;
import com.umrahoperations.UmrahOperations.dto.VisaRequestWithAgentDTO;
import com.umrahoperations.UmrahOperations.model.VisaFollowupWithAgent;
import com.umrahoperations.UmrahOperations.model.VisaFollowups;

import com.umrahoperations.UmrahOperations.repository.VisaFollowupWithAgentRepository;
import com.umrahoperations.UmrahOperations.repository.VisaFollowupsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisaFollowupService {

    @Autowired
    VisaFollowupsRepository visaFollowupsRepository;

    @Autowired
    VisaFollowupWithAgentRepository visaFollowupWithAgentRepository;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static final Logger logger = LoggerFactory.getLogger(VisaFollowupService.class);
    public List<VisaFollowupDTO> getVisaFollowups(Long eaCode) throws Exception {
        List<VisaFollowups> followupList = visaFollowupsRepository.findByEaCode(eaCode);
        logger.info(" FollowUp List SIze" + followupList.size());
        if (followupList.isEmpty()) {
            throw new Exception("Visa Followups List Empty");
        }
        List<VisaFollowupDTO> followupDTOList = new ArrayList<>();
        for (VisaFollowups followup : followupList) {
            logger.info(" FollowUp " + followup.getGotVisa());
            VisaFollowupDTO visaFollowupDTO = new VisaFollowupDTO();
            visaFollowupDTO.setWithAgent(followup.getWithAgent());
            visaFollowupDTO.setWithCompany(followup.getWithCompany());
            visaFollowupDTO.setPayment(followup.getPayment());
            visaFollowupDTO.setApproved(followup.getApproved());
            visaFollowupDTO.setRejected(followup.getRejected());
            visaFollowupDTO.setGotVisa(followup.getGotVisa());
            followupDTOList.add(visaFollowupDTO);
        }
        return followupDTOList;
    }

    public List<VisaRequestWithAgentDTO> getVisaFollowupsWithAgent(Long eaCode) throws Exception {
        logger.info("Fetching in Service");

        List<Object[]> listWithAgent = visaFollowupWithAgentRepository.findByAgentAndEaCode(eaCode);
        logger.info("With Agent List size: {}", listWithAgent.size());

        if (listWithAgent.isEmpty()) {
            throw new Exception("Agent List Empty");
        }

        List<VisaRequestWithAgentDTO> followupWithAgentList = new ArrayList<>();

        for (Object[] objects : listWithAgent) {
            try {
                VisaRequestWithAgentDTO followupWithAgent = VisaRequestWithAgentDTO.builder()
                        .vrId(parseInteger(objects[0]))
                        .travelDate(parseLocalDate(objects[1]))
                        .eaCode(parseInteger(objects[2]))
                        .agentName(objects[3] != null ? objects[3].toString() : null)
                        .visaPriceId(parseInteger(objects[5]))
                        .visaType(objects[6] != null ? objects[6].toString() : null)
                        .countryName(objects[8] != null ? objects[8].toString() : null)
                        .visaRequest(objects[10] != null ? objects[10].toString() : null)
                        .vrTotalPax(parseInteger(objects[19]))
                        .vrTotalSourceAmount(parseBigDecimal(objects[26]))
                        .vrTotalAgentAmount(parseBigDecimal(objects[28]))
                        .vrStatus(parseInteger(objects[30]))
                        .build();

                followupWithAgentList.add(followupWithAgent);
            } catch (Exception e) {
                logger.error("Error mapping record: {}", Arrays.toString(objects), e);
                // Continue processing other records even if one fails
                continue;
            }
        }

        if (followupWithAgentList.isEmpty()) {
            throw new Exception("No records could be processed successfully");
        }

        return followupWithAgentList;
    }

    private Integer parseInteger(Object value) {
        if (value == null) return null;
        if (value instanceof Integer) return (Integer) value;
        if (value instanceof Long) return ((Long) value).intValue();
        try {
            return Integer.valueOf(value.toString());
        } catch (NumberFormatException e) {
            logger.warn("Failed to parse integer value: {}", value);
            return null;
        }
    }

    private LocalDate parseLocalDate(Object value) {
        if (value == null) return null;
        if (value instanceof LocalDate) return (LocalDate) value;
        try {
            String dateStr = value.toString().trim();
            return LocalDate.parse(dateStr, DATE_FORMATTER);
        } catch (Exception e) {
            logger.warn("Failed to parse date value: {}", value);
            return null;
        }
    }

    private BigDecimal parseBigDecimal(Object value) {
        if (value == null) return null;
        if (value instanceof BigDecimal) return (BigDecimal) value;
        try {
            String numStr = value.toString().replaceAll("[^\\d.]", "");
            return new BigDecimal(numStr);
        } catch (NumberFormatException e) {
            logger.warn("Failed to parse decimal value: {}", value);
            return null;
        }
    }
}



