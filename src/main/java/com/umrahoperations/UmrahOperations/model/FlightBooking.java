package com.umrahoperations.UmrahOperations.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.umrahoperations.UmrahOperations.utils.StringToLocalDateConverterTwo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "FLIGHTS_BOOKING")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itf_seq")
    @SequenceGenerator(name = "itf_seq", sequenceName = "ITF_SEQ", allocationSize = 1)
    @Column(name = "ITF_ID")
    private Long itfId;

    @Column(name = "ITF_CLASS")
    private Integer itfClass;

    @Column(name = "ITF_DEP_FLIGHT_CODE")
    private Integer itfDepFlightCode;

    @Column(name = "ITF_DEP_FLIGHT_NUMBER")
    private Integer itfDepFlightNumber;

    @Column(name = "ITF_DEP_DURATION")
    private String itfDepDuration;

    @Column(name = "ITF_DEP_DEPARTURE_AIRPORT")
    private Integer itfDepDepartureAirport;

    @Column(name = "ITF_DEP_DEPARTURE_TERMINAL")
    private Integer itfDepTerminal;

    @Column(name = "ITF_DEP_DEPARTURE_FLIGHT_DATE")
   @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate itfDepDepartureFlightDate;

    @Column(name = "ITF_DEP_DEPARTURE_FLIGHT_TIME")
    private String itfDepDepartureFlightTime;

    @Column(name = "ITF_DEP_ARRIVAL_AIRPORT")
    private Integer itfDepArrivalAirport;

    @Column(name = "ITF_DEP_ARRIVAL_TERMINAL")
    private Integer itfDepArrivalTerminal;

    @Column(name = "ITF_DEP_ARRIVAL_FLIGHT_DATE")
   @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate itfDepArrivalFlightDate;

    @Column(name = "ITF_DEP_ARRIVAL_FLIGHT_TIME")
    private String itfDepArrivalFlightTime;

    @Column(name = "ITF_DEP_MEALS_AVAILABLE")
    private Integer itfDepMealsAvailable;

    @Column(name = "ITF_ARR_FLIGHT_CODE")
    private Integer itfArrFlightCode;

    @Column(name = "ITF_ARR_FLIGHT_NUMBER")
    private Integer itfArrFlightNumber;

    @Column(name = "ITF_ARR_DURATION")
    private String itfArrDuration;

    @Column(name = "ITF_ARR_DEPARTURE_AIRPORT")
    private Integer itfArrDepartureAirport;

    @Column(name = "ITF_ARR_DEPARTURE_TERMINAL")
    private Integer itfArrDepartureTerminal;

    @Column(name = "ITF_ARR_DEPARTURE_FLIGHT_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate itfArrDepartureFlightDate;

    @Column(name = "ITF_ARR_DEPARTURE_FLIGHT_TIME")
    private String itfArrDepartureFlightTime;

    @Column(name = "ITF_ARR_ARRIVAL_AIRPORT")
    private Integer itfArrArrivalAirport;

    @Column(name = "ITF_ARR_ARRIVAL_TERMINAL")
    private Integer itfArrArrivalTerminal;

    @Column(name = "ITF_ARR_ARRIVAL_FLIGHT_DATE")
   @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate itfArrArrivalFlightDate;

    @Column(name = "ITF_ARR_ARRIVAL_FLIGHT_TIME")
    private String itfArrArrivalFlightTime;

    @Column(name = "ITF_ARR_MEALS_AVAILABLE")
    private Integer itfArrMealsAvailable;

    @Column(name = "ITF_AGENT_CODE")
    private Integer itfAgentCode;

    @Column(name = "ITF_SUPPLIER_ID")
    private Integer itfSupplierId;

    @Column(name = "ITF_ADULT_QTY")
    private Integer itfAdultQty;

    @Column(name = "ITF_CHILD_QTY")
    private Integer itfChildQty;

    @Column(name = "ITF_INFANT_QTY")
    private Integer itfInfantQty;

    @Column(name = "ITF_ADULT_PRICE")
    private BigDecimal itfAdultPrice;

    @Column(name = "ITF_CHILD_PRICE")
    private BigDecimal itfChildPrice;

    @Column(name = "ITF_INFANT_PRICE")
    private BigDecimal itfInfantPrice;

    @Column(name = "ITF_EDATE")
   @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate itfEdate;

    @Column(name = "ITF_EUSER")
    private Integer itfEuser;

    @Column(name = "ITF_STATUS")
    private Integer itfStatus;

    @OneToMany(mappedBy = "flightBooking", cascade = CascadeType.ALL)
    private List<FlightTraveller> travellers;
}
