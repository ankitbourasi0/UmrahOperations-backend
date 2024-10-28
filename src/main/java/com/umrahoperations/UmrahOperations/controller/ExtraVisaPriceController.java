package com.umrahoperations.UmrahOperations.controller;

import com.umrahoperations.UmrahOperations.dto.ExtraVisaPriceDTO;
import com.umrahoperations.UmrahOperations.dto.VisaPriceWithRateResponseDTO;

import com.umrahoperations.UmrahOperations.service.ExtraVisaService;
import com.umrahoperations.UmrahOperations.service.ExtranetVisaPriceService;
import com.umrahoperations.UmrahOperations.utils.CurrentUserUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExtraVisaPriceController {

    @Autowired
    private ExtranetVisaPriceService extranetVisaPriceService;

    @Autowired
    private CurrentUserUtil currentUserUtil;

    @Autowired
    private HttpServletRequest request;


    @GetMapping("/extravisaprice")
    public ResponseEntity<List<VisaPriceWithRateResponseDTO>> getExtraVisaPrice() {
        Integer userCountryCode = currentUserUtil.getCurrentUserCountryCode(request);
        if (userCountryCode == null) {
            return ResponseEntity.badRequest().build();
        }
        List<VisaPriceWithRateResponseDTO> visaPricesWithRate = extranetVisaPriceService.getVisaPricesWithRateByCountryId(userCountryCode);
        return ResponseEntity.ok(visaPricesWithRate);
    }
}
