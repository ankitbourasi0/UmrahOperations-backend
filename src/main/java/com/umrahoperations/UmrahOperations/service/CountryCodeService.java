package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.repository.CountryCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryCodeService {
    @Autowired
    private CountryCodeRepository countryCodeRepository;

    public Integer getCountryCode() {
        Integer countryCode= countryCodeRepository.getExtraVisaPrice();
        return countryCode;
    }
}
