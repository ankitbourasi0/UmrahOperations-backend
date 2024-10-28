package com.umrahoperations.UmrahOperations.controller;

import com.umrahoperations.UmrahOperations.dto.VisaFollowupDTO;
import com.umrahoperations.UmrahOperations.dto.VisaRequestWithAgentDTO;
import com.umrahoperations.UmrahOperations.model.VisaFollowupWithAgent;
import com.umrahoperations.UmrahOperations.service.VisaFollowupService;
import com.umrahoperations.UmrahOperations.service.VisaRequestService;
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

//    @GetMapping("/with-agent/{eacode}")
//    public ResponseEntity<List<VisaFollowupWithAgent>> getVisaRequests(@PathVariable Long eacode) {
//        return ResponseEntity.ok(visaFollowupService.getVisaRequestsByEaCode(eacode));
//    }


    @GetMapping("/by-ea-code/{eaCode}")
    public ResponseEntity<List<VisaRequestWithAgentDTO>> getVisaRequestsByEaCode(@PathVariable Long eaCode) {
        List<VisaRequestWithAgentDTO> visaRequests = visaFollowupService.getVisaRequestsByEaCode(eaCode);
        return ResponseEntity.ok(visaRequests);
    }
}
