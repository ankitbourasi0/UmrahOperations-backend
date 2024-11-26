package com.umrahoperations.UmrahOperations.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelBookingDTLDTO {
    private Long hbdId;
    private Integer hbdCityId;
    private Long hbdHotelId;
    private Long hbdRoomType;
    private Integer hbdMeals;
    private LocalDate hbdInDate;
    private Integer hbdNights;
    private LocalDate hbdOutDate;
    private Integer hbdNoOfPax;
    private Integer hbdNoOfRoom;
    private Double hbdSaleAmount;
    private Double hbdPurAmount;
    private String hbdRemarks;
    private LocalDate hbdConfirmationDt;
    private Long hbdPurchaseCo;
    private Integer hbdStatus;
    private Integer hbdRoomView;
    private Integer hbdSharing;

    private Long hbdUuser;
    private LocalDate hbdUdate;
}