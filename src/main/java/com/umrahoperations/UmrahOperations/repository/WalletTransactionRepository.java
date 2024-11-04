package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.model.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface WalletTransactionRepository  extends JpaRepository<WalletTransaction, Long> {

    @Query(value = "select * from wallet_master_view where ea_code= :ea_code",nativeQuery = true)
    List<WalletTransaction> findAllWithNativeQuery(@Param("ea_code")  Long ea_code);
}
