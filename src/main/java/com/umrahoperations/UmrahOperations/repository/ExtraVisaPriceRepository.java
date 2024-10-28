package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.dto.ExtraVisaPriceDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtraVisaPriceRepository extends JpaRepository<ExtraVisaPriceDTO, Integer> {


    @Query(value = "select * from Luk_Currency_View where lc_id = :VP_ID and source_id = :VP_CURRENCY_ID",nativeQuery = true)
    List<ExtraVisaPriceDTO> getExtraVisaPrices(Integer VP_ID, Integer VP_CURRENCY_ID);

    @Query(value = "SELECT todays_rate FROM Luk_Currency_View WHERE currency_id = :currencyId ORDER BY date DESC LIMIT 1", nativeQuery = true)
    Double getTodaysRate(@Param("currencyId") Integer currencyId);
}
