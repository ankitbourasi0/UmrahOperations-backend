package com.umrahoperations.UmrahOperations.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity     
public class PassportDTO {

    private Integer mt_title;
    private String title_name_la;
    private String mt_first_name;
    private String mt_last_name;
    private String date_of_birth;
    private String passport_expiry;
    @Id
    private String mt_passport;
}
