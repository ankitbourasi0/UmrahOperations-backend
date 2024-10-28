package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.Traveller;
import com.umrahoperations.UmrahOperations.model.VisaRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TravellerRepository extends JpaRepository<Traveller, Long> {
}
