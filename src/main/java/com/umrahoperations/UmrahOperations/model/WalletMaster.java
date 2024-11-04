package com.umrahoperations.UmrahOperations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"WALLET_MASTER\"")
public class WalletMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WM_ID", nullable = false)
    private Long wmId;

    @Column(name = "WM_DATE")
    @Temporal(TemporalType.DATE)
    private Date wmDate;

    @Column(name = "WM_AGENT_ID")
    private Long wmAgentId;

    @Column(name = "EM_VOUCHER_DATE")
    @Temporal(TemporalType.DATE)
    private Date emVoucherDate;

    @Column(name = "EM_REFERENCE", length = 50)
    private String emReference;

    @Column(name = "EM_AMOUNT", precision = 10, scale = 2)
    private BigDecimal emAmount;

    @Column(name = "EM_PAYMENT_MODE")
    private Integer emPaymentMode;

    @Column(name = "EM_CURRENCY")
    private Integer emCurrency;

    @Column(name = "EM_NARRATION", length = 500)
    private String emNarration;

    @Column(name = "EM_FILE_NAME", length = 100)
    private String emFileName;

    @Column(name = "EM_EDATE")
    @Temporal(TemporalType.DATE)
    private Date emEdate;

    @Column(name = "EM_EUSER")
    private Long emEuser;

    @Column(name = "WM_STATUS")
    private Integer wmStatus;

    @Column(name = "WM_BANK_ACCOUNT")
    private Long wmBankAccount;

    @Column(name = "WM_CREDIT_ACCOUNT")
    private Long wmCreditAccount;

    @Column(name = "WM_ENTITY_ID")
    private Long wmEntityId;
}