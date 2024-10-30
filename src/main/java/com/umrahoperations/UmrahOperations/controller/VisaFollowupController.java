package com.umrahoperations.UmrahOperations.controller;

import com.umrahoperations.UmrahOperations.dto.VisaFollowupDTO;
import com.umrahoperations.UmrahOperations.dto.VisaRequestWithAgentDTO;
import com.umrahoperations.UmrahOperations.model.VisaFollowupWithAgent;
import com.umrahoperations.UmrahOperations.service.VisaFollowupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visa-followups")
public class VisaFollowupController {


    @Autowired
    private VisaFollowupService visaFollowupService;
    private static final Logger logger = LoggerFactory.getLogger(VisaFollowupController.class);


    @GetMapping("/test")
    public ResponseEntity<String> test() {
        logger.info("Test endpoint hit");
        return ResponseEntity.ok("Controller is working!");
    }

    @GetMapping("/{eacode}")
    public ResponseEntity<List<VisaFollowupDTO>> getVisaFollowups(@PathVariable Long eacode) throws Exception {
      try {
          logger.info("Fetching visa followup for EA Code: {}", eacode);
          List<VisaFollowupDTO> followups = visaFollowupService.getVisaFollowups(eacode);
          logger.info("Found {} records", followups.size());
          return ResponseEntity.ok(followups);
      }
         catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/with-agent/{eacode}")
    public ResponseEntity<List<VisaRequestWithAgentDTO>> getVisaFollowupsWithAgent(@PathVariable Long eacode) {
        try {
            logger.info("Fetching with Agent for EA Code: {}", eacode);
            List<VisaRequestWithAgentDTO> listWithAgent = visaFollowupService.getVisaFollowupsWithAgent(eacode);

            if (listWithAgent.isEmpty()) {
                logger.warn("No records found for EA Code: {}", eacode);
                return ResponseEntity.noContent().build();
            }

            logger.info("Found {} records", listWithAgent.size());
            return ResponseEntity.ok(listWithAgent);

        } catch (Exception e) {
            logger.error("Error fetching visa followups with agent for EA Code: {}", eacode, e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
