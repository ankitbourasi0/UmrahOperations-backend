package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.dto.PaymentModeDTO;
import com.umrahoperations.UmrahOperations.repository.PaymentMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentModeService {

    @Autowired
    private PaymentMode paymentMode;
    private  static  final Logger logger = LoggerFactory.getLogger(PaymentModeService.class);

    public List<PaymentModeDTO> getPaymentModes(){
        logger.info("getPaymentModes Fetching");
        return paymentMode.getPaymentModes();
    }
}
