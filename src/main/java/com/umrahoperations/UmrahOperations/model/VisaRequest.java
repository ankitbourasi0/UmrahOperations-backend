package com.umrahoperations.UmrahOperations.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "VISA_REQUEST")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisaRequest {
    @Id
    @Column(name = "VR_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visa_req_seq")
    @SequenceGenerator(name = "visa_req_seq", sequenceName = "VISA_REQUEST_SEQ", allocationSize = 1)
    private Long vrId;

    @Column(name = "VR_DATE")
    private LocalDate vrDate;

    @Column(name = "VR_AGENT_CODE")
    private Long vrAgentCode;

        @Column(name = "VR_VISA_PRICE_ID")
    private Long vrVisaPriceId;

    @Column(name = "VR_SOURCE_CURRENCY")
    private Integer vrSourceCurrency;

    @Column(name = "VR_AGENT_CURRENCY")
    private Integer vrAgentCurrency;

    @Column(name = "VR_CURRENCY_RATE")
    private BigDecimal vrCurrencyRate;

    @Column(name = "VR_TOTAL_PAX")
    private Integer vrTotalPax;

    @Column(name = "VR_TOTAL_SOURCE_AMOUNT")
    private BigDecimal vrTotalSourceAmount;

    @Column(name = "VR_TOTAL_AGENT_AMOUNT")
    private BigDecimal vrTotalAgentAmount;

    @Column(name = "VR_STATUS")
    private Integer vrStatus;


    @Column(name = "VR_EUSER")
    private Long vruserId;

//    VR_EDATE                DATE                  DEFAULT sysdate,

    @Column(name = "VR_TOKEN")
    private String vrToken;

        //    VR_UUSER                NUMBER(10),
//    VR_UDATE                DATE

    @Column(name = "VR_EDATE")
    private LocalDate vrEdate;

    @Column(name = "VR_SUPPLIER_ID")
    private Long vrSupplierId;
}