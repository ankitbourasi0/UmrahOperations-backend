package com.umrahoperations.UmrahOperations.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.umrahoperations.UmrahOperations.utils.StringToLocalDateConverterTwo;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "FLIGHT_TRAVELLERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightTraveller {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ft_seq")
    @SequenceGenerator(name = "ft_seq", sequenceName = "FT_SEQ", allocationSize = 1)
    @Column(name = "MT_ID")
    private Long ftId;

    @ManyToOne
    @JoinColumn(name = "FT_FB_ID")
    private FlightBooking flightBooking;

    @Column(name = "FT_TITLE")
    private Integer ftTitle;

    @Column(name = "FT_FIRST_NAME")
    private String ftFirstName;

    @Column(name = "FT_LAST_NAME")
    private String ftLastName;

    @Column(name = "FT_DOB")
   @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate ftDob;

    @Column(name = "FT_AGE")
    private Integer ftAge;

    @Column(name = "FT_EXPIRY_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate ftExpiryDate;

    @Column(name = "FT_PASSPORT")
    private String ftPassport;

    @Column(name = "FT_ADULT_PRICE")
    private BigDecimal ftAdultPrice;

    @Column(name = "FT_CHILD_PRICE")
    private BigDecimal ftChildPrice;

    @Column(name = "FT_INFANT_PRICE")
    private BigDecimal ftInfantPrice;

    @Column(name = "FT_SOURCE_CURRENCY")
    private Integer ftSourceCurrency;

    @Column(name = "FT_AGENT_CURRENCY")
    private Integer ftAgentCurrency;

    @Column(name = "FT_EDATE")
   @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate ftEdate;

    @Column(name = "FT_STATUS")
    private Integer ftStatus;

    @Column(name = "FT_PASSPORT_PIC_FILE")
    private String ftPassportPicFile;

    @Column(name = "FT_PASSPORT_FILE")
    private String ftPassportFile;

    @Column(name = "FT_AGET_CODE")
    private Integer ftAgentCode;
}