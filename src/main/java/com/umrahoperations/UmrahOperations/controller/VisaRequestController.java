package com.umrahoperations.UmrahOperations.controller;

import com.umrahoperations.UmrahOperations.dto.VisaRequestDTO;
import com.umrahoperations.UmrahOperations.model.VisaRequest;
import com.umrahoperations.UmrahOperations.utils.InsufficientWalletBalanceException;
import com.umrahoperations.UmrahOperations.service.VisaRequestService;
import com.umrahoperations.UmrahOperations.utils.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visa-requests")
@Slf4j
public class VisaRequestController {

    private final VisaRequestService visaRequestService;

    @Autowired
    public VisaRequestController(VisaRequestService visaRequestService) {
        this.visaRequestService = visaRequestService;
    }

    @PostMapping
    public ResponseEntity<?> createVisaRequest(@RequestBody VisaRequestDTO requestDTO) {
        try {
            System.out.println("request DTO: " +       requestDTO.toString());
            VisaRequest createdRequest = visaRequestService.createVisaRequest(requestDTO);
            return ResponseEntity.ok(createdRequest);
        } catch (InsufficientWalletBalanceException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            log.error("Error creating visa request", e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Failed to create visa request. Please try again later."));
        }
    }
    
    
    @PostMapping("/delete")
    public ResponseEntity<?> deleteVisaRequestRecord(@RequestBody VisaRequestDTO visa)
    {
    	try {
    		boolean check = visaRequestService.deleteVisaRequest(visa);
        	return ResponseEntity.ok(check);
		} catch (Exception e) {
			 log.error("Error creating visa request", e);
	            return ResponseEntity
	                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body(new ErrorResponse("Failed to create visa request. Please try again later."));
		}
    	
    }
}
