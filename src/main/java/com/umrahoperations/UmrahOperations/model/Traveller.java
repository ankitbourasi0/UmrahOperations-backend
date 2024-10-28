package com.umrahoperations.UmrahOperations.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

//Traveller: Maps to the MUT_TRAVELLERS table

@Entity
@Table(name = "MUT_TRAVELLERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Traveller {
    @Id
    @Column(name = "MT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "traveller_seq")
    @SequenceGenerator(name = "traveller_seq", sequenceName = "MUT_TRAVELLERS_SEQ", allocationSize = 1)
    private Long mtId;

    @Column(name = "MT_VISA_REQUEST")
    private Long mtVisaRequest;

    @Column(name = "MT_TITLE")
    private Integer mtTitle;

    @Column(name = "MT_FIRST_NAME")
    private String mtFirstName;

    @Column(name = "MT_LAST_NAME")
    private String mtLastName;

    @Column(name = "MT_DOB")
    private LocalDate mtDob;

    @Column(name = "MT_PASSPORT")
    private String mtPassport;

    @Column(name = "MT_NATIONALITY")
    private Integer mtNationality;

    @Column(name = "MT_ADULT_PRICE")
    private BigDecimal mtAdultPrice;

    @Column(name = "MT_CHILD_PRICE")
    private BigDecimal mtChildPrice;

    @Column(name = "MT_INFANT_PRICE")
    private BigDecimal mtInfantPrice;

    @Column(name = "MT_SOURCE_CURRENCY")
    private Integer mtSourceCurrency;

    @Column(name = "MT_AGENT_CURRENCY")
    private Integer mtAgentCurrency;

    @Column(name = "MT_STATUS")
    private Integer mtStatus;

    @Column(name = "MT_EDATE")
    private LocalDate mtEdate;

    @Column(name = "MT_AGE")
    private int mtAge;

    @Column(name = "MT_EXPIRY_DATE")
    private LocalDate mtExpiryDate;

    @Column(name = "MT_EA_CODE")
    private Long mtEaCode;
}