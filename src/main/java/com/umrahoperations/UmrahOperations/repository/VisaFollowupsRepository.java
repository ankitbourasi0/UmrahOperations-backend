package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.VisaFollowups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisaFollowupsRepository extends JpaRepository<VisaFollowups, Integer> {

    @Query(value = "SELECT * FROM Visa_Followup_View WHERE ea_code = :eaCode", nativeQuery = true)
    List<VisaFollowups> findByEaCode(@Param("eaCode") Long eaCode);



}
