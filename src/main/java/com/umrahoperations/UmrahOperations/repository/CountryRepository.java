package com.umrahoperations.UmrahOperations.repository;



import com.umrahoperations.UmrahOperations.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query(value = "SELECT * FROM v_countries", nativeQuery = true)
    List<Object[]> findAllCountries();
}
