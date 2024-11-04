package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.dto.PaymentModeDTO;
import com.umrahoperations.UmrahOperations.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {

        @Query(value = "SELECT * From Cashbank_Account_Master Where ENTITY_ID = :entityID ",nativeQuery = true)
        List<Wallet> getByEntityID(@Param("entityID") Long entityID);



}
