package com.umrahoperations.UmrahOperations.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class ExtranetVisaPrice {

    @Id
    @Column(name = "VP_ID")
    private Long id;

    @Column(name = "VP_VISA_TYPE")
    private Integer visaType;

    @Column(name = "VT_NAME_LA")
    private String visaTypeNameLa;

    @Column(name = "VT_NAME_AR")
    private String visaTypeNameAr;

    @Column(name = "VP_ENTRY_TYPE")
    private Integer entryType;

    @Column(name = "VET_NAME_LA")
    private String entryTypeNameLa;

    @Column(name = "VET_NAME_AR")
    private String entryTypeNameAr;

    @Column(name = "VP_DURATION")
    private Integer duration;

    @Column(name = "VD_NAME_LA")
    private String durationNameLa;

    @Column(name = "VD_NAME_AR")
    private String durationNameAr;

    @Column(name = "VP_SUPPLIER")
    private Long supplierId;

    @Column(name = "SUPPLIER_NAME_LA")
    private String supplierNameLa;

    @Column(name = "SUPPLIER_NAME_AR")
    private String supplierNameAr;

    @Column(name = "VP_NAME_LA")
    private String nameLa;

    @Column(name = "VP_NAME_AR")
    private String nameAr;

    @Column(name = "VALID_FROM")
    private String validFrom;

    @Column(name = "VALID_UPTO")
    private String validUpto;

    @Column(name = "VP_CURRENCY_ID")
    private Integer currencyId;

    @Column(name = "LC_SHORT_CODE")
    private String currencyShortCode;

    @Column(name = "VP_SALE_NETT_ADULT")
    private Double saleNettAdult;

    @Column(name = "VP_SALE_NETT_CHILD")
    private Double saleNettChild;

    @Column(name = "VP_SALE_NETT_INFANT")
    private Double saleNettInfant;

    @Column(name = "VP_COUNTRY")
    private Integer countryId;

    @Column(name = "CNTRY_NAME_LA")
    private String countryNameLa;

    @Column(name = "CNTRY_NAME_AR")
    private String countryNameAr;

    @Column(name = "VP_PROCESSING_TIME")
    private String processingTime;

    @Column(name = "CNTRY_FLAG")
    private String countryFlag;
}