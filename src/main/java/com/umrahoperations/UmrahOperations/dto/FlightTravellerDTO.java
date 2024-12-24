package com.umrahoperations.UmrahOperations.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.umrahoperations.UmrahOperations.utils.StringToLocalDateConverterTwo;
import jakarta.persistence.Convert;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightTravellerDTO {
    private Long ftId;
    private Long ftFbId;  // References the FlightBooking
    private Integer ftTitle;
    private String ftFirstName;
    private String ftLastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate ftDob;
    private Integer ftAge;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate ftExpiryDate;
    private String ftPassport;
    private BigDecimal ftAdultPrice;
    private BigDecimal ftChildPrice;
    private BigDecimal ftInfantPrice;
    private Integer ftSourceCurrency;
    private Integer ftAgentCurrency;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate ftEdate;
    private Integer ftStatus;
    private String ftPassportPicFile;
    private String ftPassportFile;
    private Integer ftAgentCode;
}