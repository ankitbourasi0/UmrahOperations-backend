package com.umrahoperations.UmrahOperations.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Wallet {

    @Id
    @Column(name = "ACC_ID")
    private Long accId;
    @Column(name = "ACC_SGRP_ID")
    private int accSgrpId;
    @Column(name = "ACC_NAME_LA")
    private String accNameLa;
    @Column(name = "ACC_NAME_AR")
    private String accNameAr;
    @Column(name = "ENTITY_ID")
    private Long entityId;


}
