package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.dto.ExtraVisaPriceDTO;
import com.umrahoperations.UmrahOperations.dto.VisaPriceWithRateResponseDTO;
import com.umrahoperations.UmrahOperations.dto.VisaPriceWithRateResponseDTO;
import com.umrahoperations.UmrahOperations.model.ExtranetVisaPrice;
import com.umrahoperations.UmrahOperations.repository.ExtraVisaPriceRepository;
import com.umrahoperations.UmrahOperations.repository.ExtranetVisaPriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class ExtranetVisaPriceService {

    @Autowired
    private ExtranetVisaPriceRepository extranetVisaPriceRepository;


    private static final Logger logger = LoggerFactory.getLogger(ExtranetVisaPriceService.class);


    public List<VisaPriceWithRateResponseDTO> getVisaPricesWithRateByCountryId(Integer countryId) {

        logger.info("CountryID: {}", countryId);

        //List of ExtraNetVisaPrice give VP_CURRENCY_ID and other details for response
        List<ExtranetVisaPrice> visaPricesList  =  extranetVisaPriceRepository.getExtraNetVisaPrice();
        logger.info("VisaPricesList: {}", visaPricesList);

        List<Integer> countryCodeList =  visaPricesList.stream().map(e-> e.getCurrencyId() ).collect(Collectors.toList());

        logger.info("CountryCodeList: {}", countryCodeList);
        Double todaysRate =   extranetVisaPriceRepository.getExtraVisaPrices(countryId, countryCodeList.get(0));

        logger.info("todaysRate: {}", todaysRate);
        if (todaysRate == null) {
            return null;
        }

            return visaPricesList.stream()
                    .map(visaPrice -> new VisaPriceWithRateResponseDTO(visaPrice, todaysRate))
                    .collect(Collectors.toList());


    }
}