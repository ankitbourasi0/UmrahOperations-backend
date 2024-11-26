package com.umrahoperations.UmrahOperations.model;

import com.umrahoperations.UmrahOperations.utils.StringToLocalDateConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "Res_Hotel_Booking_View")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelFollowup {
    @Id
    private String id; // This is needed for JPA even though we're using native query

    @Transient // Fields marked as transient won't be mapped by JPA
    private String bookingId;

    @Transient
    private String bookingDate;

    @Transient
    private String agentId;

    @Transient
    private String agentName;

    @Transient
    private String supplier;

    @Transient
    private Integer cityId;

    @Transient
    private String cityName;

    @Transient
    private String hotelId;

    @Transient
    private String hotelName;

    @Transient
    private Double saleAmount;

    @Transient
    private Integer status;

    @Transient
    private String statusName;

    @Transient
    private String agentCurrency;

    @Transient
    private Double totalAmount;

    @Transient
    private Integer bookingType;

    @Transient
    private String optionDate;

    @Transient
    private String token;
}