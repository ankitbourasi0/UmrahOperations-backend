package com.umrahoperations.UmrahOperations.service;



import com.umrahoperations.UmrahOperations.model.Country;
import com.umrahoperations.UmrahOperations.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {


    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        List<Object[]> results = countryRepository.findAllCountries();
        return results.stream()
                .map(result -> new Country(
                        (Integer) result[0],
                        (String) result[1]
                ))
                .collect(Collectors.toList());
    }
}