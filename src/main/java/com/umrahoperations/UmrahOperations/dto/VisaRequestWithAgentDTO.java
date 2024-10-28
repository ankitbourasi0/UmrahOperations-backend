package com.umrahoperations.UmrahOperations.dto;
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

    private Long vrId;
    private LocalDate travelDate;
    private Long eaCode;
    private String agentName;
    private Long visaPriceId;
    private String visaType;
    private String countryName;
    private String visaRequest;
    private Integer vrTotalPax;
    private BigDecimal vrTotalSourceAmount;
    private BigDecimal vrTotalAgentAmount;
    private Integer vrStatus;
}
