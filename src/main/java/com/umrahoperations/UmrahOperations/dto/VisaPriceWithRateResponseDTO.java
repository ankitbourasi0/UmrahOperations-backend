package com.umrahoperations.UmrahOperations.dto;

import com.umrahoperations.UmrahOperations.model.ExtranetVisaPrice;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VisaPriceWithRateResponseDTO {
    private Long id;
    private Integer visaType;
    private String visaTypeNameLa;
    private String visaTypeNameAr;
    private Integer entryType;
    private String entryTypeNameLa;
    private String entryTypeNameAr;
    private Integer duration;
    private String durationNameLa;
    private String durationNameAr;
    private Long supplierId;
    private String supplierNameLa;
    private String supplierNameAr;
    private String nameLa;
    private String nameAr;
    private String validFrom;
    private String validUpto;
    private Integer currencyId;
    private String currencyShortCode;
    private Double saleNettAdult;
    private Double saleNettChild;
    private Double saleNettInfant;
    private Integer countryId;
    private String countryNameLa;
    private String countryNameAr;
    private String processingTime;
    private String countryFlag;
    private Double todaysRate;

    public VisaPriceWithRateResponseDTO(ExtranetVisaPrice visaPrice, Double todaysRate) {
        this.id = visaPrice.getId();
        this.visaType = visaPrice.getVisaType();
        this.visaTypeNameLa = visaPrice.getVisaTypeNameLa();
        this.visaTypeNameAr = visaPrice.getVisaTypeNameAr();
        this.entryType = visaPrice.getEntryType();
        this.entryTypeNameLa = visaPrice.getEntryTypeNameLa();
        this.entryTypeNameAr = visaPrice.getEntryTypeNameAr();
        this.duration = visaPrice.getDuration();
        this.durationNameLa = visaPrice.getDurationNameLa();
        this.durationNameAr = visaPrice.getDurationNameAr();
        this.supplierId = visaPrice.getSupplierId();
        this.supplierNameLa = visaPrice.getSupplierNameLa();
        this.supplierNameAr = visaPrice.getSupplierNameAr();
        this.nameLa = visaPrice.getNameLa();
        this.nameAr = visaPrice.getNameAr();
        this.validFrom = visaPrice.getValidFrom();
        this.validUpto = visaPrice.getValidUpto();
        this.currencyId = visaPrice.getCurrencyId();
        this.currencyShortCode = visaPrice.getCurrencyShortCode();
        this.saleNettAdult = visaPrice.getSaleNettAdult();
        this.saleNettChild = visaPrice.getSaleNettChild();
        this.saleNettInfant = visaPrice.getSaleNettInfant();
        this.countryId = visaPrice.getCountryId();
        this.countryNameLa = visaPrice.getCountryNameLa();
        this.countryNameAr = visaPrice.getCountryNameAr();
        this.processingTime = visaPrice.getProcessingTime();
        this.countryFlag = visaPrice.getCountryFlag();
        this.todaysRate = todaysRate;
    }
}