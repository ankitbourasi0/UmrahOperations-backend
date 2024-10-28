package com.umrahoperations.UmrahOperations.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LoginPrevs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginPrev {
    @Id
    @Column(name = "P_ID")
    private Long id;

    @Column(name = "USER_LOGIN")
    private String userLogin;

    @Column(name = "USER_PASS")
    private String userPass;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_RT_ET_ID")
    private Integer userRtEtId;

    @Column(name = "USER_EMP_ID")
    private Integer userEmpId;

    @Column(name = "USER_STATUS")
    private Integer userStatus;

    @Column(name = "MN_HEADER_ID")
    private Integer mhHeaderId;

    @Column(name = "MH_NAME_LA")
    private String mhNameLa;

    @Column(name = "MH_NAME_AR")
    private String mhNameAr;

    @Column(name = "MN_ID")
    private Integer mnId;

    @Column(name = "MN_NAME_LA")
    private String mnNameLa;

    @Column(name = "MN_NAME_AR")
    private String mnNameAr;


    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USER_COUNTRY",nullable = false)
    private int countryCode;

    @Column(name = "USER_EA_CODE")
    private Long eaCode;

    // Add getters and setters for all fields
}