package com.umrahoperations.UmrahOperations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

//TravellerDTO: For receiving traveller information


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravellerDTO {
    private Integer title;
    private String firstName;
    private String lastName;
    private String passportNo;
    private LocalDate dateOfBirth;
    private LocalDate passportExpiry;
    private BigDecimal adultPrice;
    private BigDecimal childPrice;
    private BigDecimal infantPrice;
//    private Integer nationality;
}



