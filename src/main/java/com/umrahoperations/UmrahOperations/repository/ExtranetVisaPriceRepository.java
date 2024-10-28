package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.dto.ExtraVisaPriceDTO;
import com.umrahoperations.UmrahOperations.model.ExtranetVisaPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtranetVisaPriceRepository extends JpaRepository<ExtranetVisaPrice, Long> {

    @Query(value = "SELECT * From Extranet_Visa_Price", nativeQuery = true)
    List<ExtranetVisaPrice> getExtraNetVisaPrice();


    @Query(value = "select todays_rate from Luk_Currency_View where lc_id = :VP_ID and source_id = :VP_CURRENCY_ID",nativeQuery = true)
   Double getExtraVisaPrices(Integer VP_ID, Integer VP_CURRENCY_ID);




}