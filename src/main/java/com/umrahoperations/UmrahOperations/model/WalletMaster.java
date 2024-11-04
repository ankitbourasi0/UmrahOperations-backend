package com.umrahoperations.UmrahOperations.model;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WALLET_MASTER")
@SequenceGenerator(name="USER_SEQUENCE_GENERATOR", sequenceName="WALLET_SEQ", initialValue=100001, allocationSize=1)
public class WalletMaster {
	

    @Id
    @Column(name = "WM_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQUENCE_GENERATOR")
    private Long wmId;

    @Column(name = "WM_DATE")
    private Date wmDate;

    @Column(name = "WM_AGENT_ID")
    private int wmAgentId;

    @Column(name = "EM_VOUCHER_DATE")
    private Date emVoucherDate;

    @Column(name = "EM_REFERENCE")
    private String emReference;

    @Column(name = "EM_AMOUNT")
    private double emAmount;

    @Column(name = "EM_PAYMENT_MODE")
    private int emPaymentMode;

    @Column(name = "EM_CURRENCY")
    private Long emCurrency;

    @Column(name = "EM_NARRATION")
    private String emNarration;

    @Column(name = "EM_FILE_NAME")
    private String emFileName;

    @Column(name = "EM_EDATE")
    private Date emEdate;

    @Column(name = "EM_EUSER")
    private Long emEuser;

    @Column(name = "WM_STATUS")
    private int wmStatus;

    @Column(name = "WM_BANK_ACCOUNT")
    private Long wmBankAccount;

    @Column(name = "WM_CREDIT_ACCOUNT")
    private Long wmCreditAccount;

    @Column(name = "WM_ENTITY_ID")
    private Long wmEntityId;
}