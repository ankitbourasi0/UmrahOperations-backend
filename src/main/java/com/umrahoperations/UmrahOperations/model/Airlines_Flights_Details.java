package com.umrahoperations.UmrahOperations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Airlines_Flights_Details {

        @Id
        private Long afsId;

        private Long afsServiceId;

        private Integer afsSegment;

        private Integer afsIsReturnSegment;

        private Integer afsClass;

        private String className;

        private Integer afsFlightCode;

        private String airlinesCode;

        private String airlines;

        private String laLogo;

        private String afsFlightNumber;

        private Integer afsStops;

        private String afsDuration;

        private Integer afsDepartureAirport;

        private String depAirportCode;

        private String depAirport;

        private Integer afsDepartureTerminals;

        private String depTerminal;

        private Integer afsArrivalAirport;

        private String arrAirportCode;

        private String arrAirport;

        private Integer afsArrivalTerminals;

        private String arrTerminal;

        private String depFlightDate;

        private String depFormatDate;

        private String depFlightTime;

        private String arrFlightDate;

        private String arrFormatDate;

        private String afsArrivalFlightTime;

        private String arrFlightTime;

        private Integer afsIsDirectConnect;

        private Integer afsMealsAvailable;

        private String meals;

        private Integer afsStatus;

        private Integer asTotalSeats;

        private Long uoCode;

        private String adultPrice;

        private String adultLuggage;

        private String adultBaggage;
}
