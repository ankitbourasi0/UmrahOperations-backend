package com.umrahoperations.UmrahOperations.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "RES_HOTEL_BOOKING")
public class HotelBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RES_HOTEL_BOOKING_SEQ_GENERATOR")
    @SequenceGenerator(
            name = "RES_HOTEL_BOOKING_SEQ_GENERATOR",
            sequenceName = "RHBS_SEQ",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "HB_ID", nullable = false, precision = 10)
    private Long hbId;
    @Column(name = "HB_DATE")
    private LocalDate hbDate;
    @Column(name = "HB_CUSTOMER_ID")
    private Long hbCustomerId;
    @Column(name = "HB_SUPPLIER")
    private Long hbSupplier;
    @Column(name = "HB_CNTRY_ID")
    private Integer hbCountryId;
    @Column(name = "HB_CITY_ID")
    private Integer hbCityId;
    @Column(name = "HB_HOTEL_ID")
    private Long hbHotelId;
    @Column(name = "HB_SALE_AMOUNT")
    private Double hbSaleAmount;
    @Column(name = "HB_PURCHASE_AMOUNT")
    private Double hbPurchaseAmount;
    @Column(name = "HB_EDATE")
    private LocalDate hbEdate;
    @Column(name = "HB_EUSER")
    private Long hbEuser;
    @Column(name = "HB_UUSER")
    private Long hbUuser;
    @Column(name = "HB_UDATE")
    private LocalDate hbUdate;
    @Column(name = "HB_STATUS")
    private Integer hbStatus;
    @Column(name = "HB_AGENT_CURRENCY")
    private Integer hbAgentCurrency;
    @Column(name = "HB_TOTAL_AMOUNT")
    private Double hbTotalAmount;
    @Column(name = "HB_BOOKING_TYPE")
    private Integer hbBookingType;
    @Column(name = "HB_OPTION_DATE")
    private LocalDate hbOptionDate;
    @Column(name = "HB_TOKEN")
    private String hbToken;
    @OneToMany(mappedBy = "hotelBooking", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HotelBookingDTL> bookingDetails;
}
