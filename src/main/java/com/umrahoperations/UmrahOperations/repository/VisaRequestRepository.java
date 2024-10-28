package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.VisaRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisaRequestRepository extends JpaRepository<VisaRequest, Long> {
}