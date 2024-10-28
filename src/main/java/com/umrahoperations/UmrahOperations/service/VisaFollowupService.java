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

    public List<VisaRequestWithAgentDTO> getVisaRequestsByEaCode(Long eaCode) {
        List<VisaFollowupWithAgent> visaRequests = visaFollowupWithAgentRepository.findVisaRequestsByEaCode(eaCode);
        return visaRequests.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private VisaRequestWithAgentDTO convertToDTO(VisaFollowupWithAgent visaRequest) {
        return VisaRequestWithAgentDTO.builder()
                .vrId(visaRequest.getVrId())
                .travelDate(visaRequest.getTravelDate())
                .eaCode(visaRequest.getEaCode())
                .agentName(visaRequest.getAgentName())
                .visaPriceId(visaRequest.getVisaPriceId())
                .visaType(visaRequest.getVisaType())
                .countryName(visaRequest.getCountryName())
                .visaRequest(visaRequest.getVisaRequest())
                .vrTotalPax(visaRequest.getVrTotalPax())
                .vrTotalSourceAmount(visaRequest.getVrTotalSourceAmount())
                .vrTotalAgentAmount(visaRequest.getVrTotalAgentAmount())
                .vrStatus(visaRequest.getVrStatus())
                .build();
    }


}



