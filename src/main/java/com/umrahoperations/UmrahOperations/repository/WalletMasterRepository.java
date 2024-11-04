package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.WalletMaster;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletMasterRepository extends JpaRepository<WalletMaster, Long> {
    // Add custom query methods if needed
}