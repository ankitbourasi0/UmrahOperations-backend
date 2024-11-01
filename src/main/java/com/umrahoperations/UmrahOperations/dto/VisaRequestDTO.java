package com.umrahoperations.UmrahOperations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//VisaRequestDTO: For receiving visa request data from frontend
// Updated DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisaRequestDTO {
	private Long vrId;
    private Long visaPriceId;  // matches with VR_VISA_PRICE_ID
    private LocalDate requestDate;
    private Long agentCode;
    private String token;
    private Long vruserId;
    private Integer sourceCurrency;
    private Integer agentCurrency;
    private BigDecimal currencyRate;
    private Long supplierId;
    private List<TravellerDTO> travellers;
    private Integer visaStatus;
}