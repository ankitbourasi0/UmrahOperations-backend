package com.umrahoperations.UmrahOperations.controller;

import com.umrahoperations.UmrahOperations.dto.PaymentModeDTO;
import com.umrahoperations.UmrahOperations.service.PaymentModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/paymentmode")
public class PaymentModeController {

    @Autowired
    private PaymentModeService paymentModeService;

    @GetMapping()
    public List<PaymentModeDTO> GetPaymentMode() {
        return paymentModeService.getPaymentModes();
    }
    }
