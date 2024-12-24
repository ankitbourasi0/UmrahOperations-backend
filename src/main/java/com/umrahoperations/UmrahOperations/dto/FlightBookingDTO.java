package com.umrahoperations.UmrahOperations.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.umrahoperations.UmrahOperations.utils.StringToLocalDateConverterTwo;
import jakarta.persistence.Convert;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightBookingDTO {
    private Long itfId;
    private Integer itfClass;
    private Integer itfDepFlightCode;
    private Integer itfDepFlightNumber;
    private String itfDepDuration;
    private Integer itfDepDepartureAirport;
    private Integer itfDepTerminal;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate itfDepDepartureFlightDate;
    private String itfDepDepartureFlightTime;
    private Integer itfDepArrivalAirport;
    private Integer itfDepArrivalTerminal;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate itfDepArrivalFlightDate;
    private String itfDepArrivalFlightTime;
    private Integer itfDepMealsAvailable;
    private Integer itfArrFlightCode;
    private Integer itfArrFlightNumber;
    private String itfArrDuration;
    private Integer itfArrDepartureAirport;
    private Integer itfArrDepartureTerminal;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate itfArrDepartureFlightDate;
    private String itfArrDepartureFlightTime;
    private Integer itfArrArrivalAirport;
    private Integer itfArrArrivalTerminal;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate itfArrArrivalFlightDate;
    private String itfArrArrivalFlightTime;
    private Integer itfArrMealsAvailable;
    private Integer itfAgentCode;
    private Integer itfSupplierId;
    private Integer itfAdultQty;
    private Integer itfChildQty;
    private Integer itfInfantQty;
    private BigDecimal itfAdultPrice;
    private BigDecimal itfChildPrice;
    private BigDecimal itfInfantPrice;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate itfEdate;
    private Integer itfEuser;
    private Integer itfStatus;
    private List<FlightTravellerDTO> travellers;
}