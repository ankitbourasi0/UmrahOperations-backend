package com.umrahoperations.UmrahOperations.model;

import lombok.*;
import jakarta.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Flight_Search_Fare")
public class FlightSearchFare {

    @Id
    private Long afdId;
    private Long serviceId;
    private Integer afdFareIdentifier;
    private String afName;
    private Integer afdAdultory;
    private String aaName;
    private Double afdBasePrice;
    private Integer afdTaxPrice;
    private Integer afdTotalPrice;
    private Integer afdFlightLuggage;
    private String afdHandBaggage;
    private Integer currencyId;
    private String cntryCurrencyCode;
    private Float saudiCurrencyRate;
}
