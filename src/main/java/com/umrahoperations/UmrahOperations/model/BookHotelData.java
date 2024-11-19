package com.umrahoperations.UmrahOperations.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Book_Hotel_Data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookHotelData {
    @Id
    @Column(name = "SL")
    private Long id;

    @Column(name = "HS_SUPPLIER_ID")
    private Integer hsSupplierID;

    @Column(name = "HS_STATUS")
    private Integer hsStatus;

    @Column(name = "HS_CURRENCY")
    private Integer hsCurrency;

    @Column(name = "HM_ID")
    private Integer hmID;

    @Column(name = "HM_NAME_LA")
    private String hmNameLA;

    @Column(name = "HM_NAME_AR")
    private String hmNameAR;

    @Column(name = "HM_FEATURES")
    private String hmFeatures;

    @Column(name = "HM_DESCRIPTION")
    private String hmDescription;

    @Column(name = "HM_RESPONSIBLE")
    private String hmResponsible;

    @Column(name = "HM_CONTACTS")
    private String hmContacts;

    @Column(name = "HM_EMAIL")
    private String hmEmail;

    @Column(name = "HM_ADDRESS")
    private String hmAddress;

    @Column(name = "HM_AREA")
    private String hmArea;

    @Column(name = "HM_CITY")
    private Integer hmCity;

    @Column(name = "HM_COUNTRY")
    private Integer hmCountry;

    @Column(name = "HM_PIN_CODE")
    private String hmPinCode;

    @Column(name = "HM_CATEGORY")
    private Integer hmCategory;

    @Column(name = "LH_NAME_LA")
    private String lhNameLA;

    @Column(name = "LH_ICON")
    private String lhIcon;

    @Column(name = "HM_DISTANCE")
    private String hmDistance;

    @Column(name = "HM_LATTITUDE")
    private String hmLattitude;

    @Column(name = "HM_LONGITUDE")
    private String hmLongitude;

    @Column(name = "HM_CHECK_IN")
    private String hmCheckIn;

    @Column(name = "HM_CHECK_OUT")
    private String hmCheckOut;

    @Column(name = "HM_STATUS")
    private Integer hmStatus;

    @Column(name = "HM_LOGO")
    private String hmLogo;

    @Column(name = "FLAG_IS_AVAILABLE")
    private Integer flagIsAvailable;

    @Column(name = "OWNER")
    private Integer owner;
}