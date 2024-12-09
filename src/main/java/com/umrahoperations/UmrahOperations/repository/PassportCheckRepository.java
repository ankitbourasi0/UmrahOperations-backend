package com.umrahoperations.UmrahOperations.repository;

import com.umrahoperations.UmrahOperations.dto.PassportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassportCheckRepository extends JpaRepository<PassportDTO, String> {

    @Query(value = "select \n" +
            "mt_title,title_name_la,mt_first_name,mt_last_name,\n" +
            "date_of_birth,passport_expiry,mt_passport \n" +
            "from Mut_Travellers_View", nativeQuery = true)
    List<PassportDTO> findAllPassport();
}
