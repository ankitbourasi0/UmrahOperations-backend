package com.umrahoperations.UmrahOperations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Airlines_Flight_Search")
public class AirlinesFlight {
    @Id
    @Column(name = "AS_ID")
    private Long asId;

    @Column(name = "AS_FLIGHT_TYPE")
    private Integer asFlightType;

    @Column(name = "AS_TOTAL_SEATS")
    private Integer asTotalSeats;

    @Column(name = "AS_CURRENCY")
    private Double asCurrency;

    @Column(name = "CNTRY_CURRENCY_CODE")
    private String countryCurrencyCode;

    @Column(name = "UO_CODE")
    private String uoCode;

    @Column(name = "DEPARTURE_DATE")
    private String departureDate; // Changed from Date to LocalDate

    @Column(name = "ARRIVAL_DATE")
    private String arrivalDate; // Changed from Date to LocalDate

    @Column(name = "DAYS")
    private Integer days;
}
