package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.VisaFollowupWithAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisaFollowupWithAgentRepository extends JpaRepository<VisaFollowupWithAgent, Long> {

    @Query(value = "SELECT * FROM Visa_Request_View WHERE ea_code = :eaCode", nativeQuery = true)
    List<Object[]> findByAgentAndEaCode(@Param("eaCode") Long eaCode);

}
