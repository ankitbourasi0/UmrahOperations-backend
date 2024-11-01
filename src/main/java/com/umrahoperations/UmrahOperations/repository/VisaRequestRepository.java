package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.VisaRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VisaRequestRepository extends JpaRepository<VisaRequest, Long> {
	
	@Query("update VisaRequest set vrStatus =:status where vrId=:vrId")
	public boolean updateVisaRequestStatus(@Param(value = "status") Integer status,@Param(value = "vrId") Long vrId);
	
}