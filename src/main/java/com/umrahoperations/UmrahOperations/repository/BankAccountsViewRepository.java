package com.umrahoperations.UmrahOperations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.umrahoperations.UmrahOperations.model.BankAccountsView;

public interface BankAccountsViewRepository extends JpaRepository<BankAccountsView, Long>{

	@Query(value = "SELECT * FROM Bank_Accounts_View where entity_id=:entityId", nativeQuery = true)
    List<BankAccountsView> findByEaCode(@Param(value="entityId") Long entityId );
}
