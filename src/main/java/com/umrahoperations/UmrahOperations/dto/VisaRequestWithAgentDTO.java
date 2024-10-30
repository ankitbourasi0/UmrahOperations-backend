package com.umrahoperations.UmrahOperations.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisaRequestWithAgentDTO {
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate travelDate;

    private Integer vrId;
    private Integer eaCode;
    private String agentName;
    private Integer visaPriceId;
    private String visaType;
    private String countryName;
    private String visaRequest;
    private Integer vrTotalPax;
    private BigDecimal vrTotalSourceAmount;
    private BigDecimal vrTotalAgentAmount;
    private Integer vrStatus;
}
