package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.utils.CountryCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryCodeRepository extends JpaRepository<CountryCode, Integer> {
    @Query(value = "SELECT VP_CURRENCY_ID From Extranet_Visa_Price", nativeQuery = true)
    Integer getExtraVisaPrice();

}
