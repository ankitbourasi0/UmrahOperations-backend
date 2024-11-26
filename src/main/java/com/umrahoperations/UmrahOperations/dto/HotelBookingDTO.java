package com.umrahoperations.UmrahOperations.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelBookingDTO {
    private Long hbId;
    private LocalDate hbDate;
    private Long hbCustomerId;
    private Long hbSupplier;
    private Integer hbCountryId;
    private Integer hbCityId;
    private Long hbHotelId;
    private Double hbSaleAmount;
    private Double hbPurchaseAmount;
    private Long hbEuser;
    private Long hbUuser;
    private Integer hbStatus;
    private Integer hbAgentCurrency;
    private Double hbTotalAmount;
    private Integer hbBookingType;
    private LocalDate hbOptionDate;
    private String hbToken;
    private List<HotelBookingDTLDTO> bookingDetails;
}