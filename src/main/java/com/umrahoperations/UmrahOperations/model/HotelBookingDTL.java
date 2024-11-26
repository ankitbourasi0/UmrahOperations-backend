package com.umrahoperations.UmrahOperations.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "RES_HOTEL_BOOKING_DTL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelBookingDTL {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RES_HOTEL_BOOKING_DTL_SEQ_GENERATOR")
    @SequenceGenerator(
            name = "RES_HOTEL_BOOKING_DTL_SEQ_GENERATOR",
            sequenceName = "RHBSD_SEQ",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "HBD_ID", nullable = false, precision = 10)
    private Long hbdId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HBD_BOOKING_ID", referencedColumnName = "HB_ID")
    private HotelBooking hotelBooking;
//    @Column(name = "HBD_BOOKING_ID")
//    private Long hbdBookingId;

    @Column(name = "HBD_CITY_ID")
    private Integer hbdCityId;

    @Column(name = "HBD_HOTEL_ID")
    private Long hbdHotelId;

    @Column(name = "HBD_ROOM_TYPE")
    private Long hbdRoomType;

    @Column(name = "HBD_MEALS")
    private Integer hbdMeals;

    @Column(name = "HBD_IN_DATE")
    private LocalDate hbdInDate;

    @Column(name = "HBD_NIGHTS")
    private Integer hbdNights;

    @Column(name = "HBD_OUT_DATE")
    private LocalDate hbdOutDate;

    @Column(name = "HBD_NO_OF_PAX")
    private Integer hbdNoOfPax;

    @Column(name = "HBD_NO_OF_ROOM")
    private Integer hbdNoOfRoom;

    @Column(name = "HBD_SALE_AMOUNT")
    private Double hbdSaleAmount;

    @Column(name = "HBD_PUR_AMOUNT")
    private Double hbdPurAmount;

    @Column(name = "HBD_REMARKS")
    private String hbdRemarks;

    @Column(name = "HBD_UUSER")
    private Long hbdUuser;

    @Column(name = "HBD_UDATE")
    private LocalDate hbdUdate;

    @Column(name = "HBD_CONFIRMATION_DT")
    private LocalDate hbdConfirmationDt;

    @Column(name = "HBD_PURCHASE_CO")
    private Long hbdPurchaseCo;

    @Column(name = "HBD_STATUS")
    private Integer hbdStatus;

    @Column(name = "HBD_ROOM_VIEW")
    private Integer hbdRoomView;

    @Column(name = "HBD_SHARING")
    private Integer hbdSharing;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "HBD_BOOKING_ID", referencedColumnName = "HB_ID", insertable = false, updatable = false)
//    private HotelBooking hotelBooking;

}