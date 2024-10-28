package com.umrahoperations.UmrahOperations.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"Visa_Request_View\"")
public class VisaFollowupWithAgent {

    @Id
    @Column(name = "VR_ID")
    private Long vrId;

    @Column(name = "TRAVEL_DATE")
    private LocalDate travelDate;

    @Column(name = "EA_CODE")
    private Long eaCode;

    @Column(name = "AGENT_NAME_LA")
    private String agentName;

    @Column(name = "VR_VISA_PRICE_ID")
    private Long visaPriceId;


    @Column(name = "VISA_TYPE_LA")
    private String visaType;

    @Column(name = "CNTRY_NAME_LA")
    private String countryName;

    @Column(name = "VP_NAME_LA")
    private String visaRequest;

    @Column(name = "VR_TOTAL_PAX")
    private Integer vrTotalPax;

    @Column(name = "VR_TOTAL_SOURCE_AMOUNT")
    private BigDecimal vrTotalSourceAmount;

    @Column(name = "VR_TOTAL_AGENT_AMOUNT")
    private BigDecimal vrTotalAgentAmount;


    @Column(name = "VR_STATUS")
    private Integer vrStatus;


}
