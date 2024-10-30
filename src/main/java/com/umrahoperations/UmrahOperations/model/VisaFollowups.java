package com.umrahoperations.UmrahOperations.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"Visa_Followup_View\"")
public class VisaFollowups {

    @Id
    private Integer sl;

    @Column(name = "WITH_AGENT")
    private int withAgent;

    @Column(name = "WITH_COMPANY")
    private int withCompany;

    @Column(name = "PAYMENT")
    private int payment;

    @Column(name = "APPROVED")
    private int approved;

    @Column(name = "REJECTED")
    private int rejected;

    @Column(name = "GOT_VISA")
    private int gotVisa;

    @Column(name = "EA_CODE")
    private Long EaCode;

    @Column(name = "UO_CODE")
    private Long UoCode;

}
