package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.dto.PaymentModeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMode extends JpaRepository<PaymentModeDTO, Integer> {

        @Query(value= "SELECT * FROM V_Luk_Payment_Mode",nativeQuery = true)
        List<PaymentModeDTO> getPaymentModes();
}

