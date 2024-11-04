package com.umrahoperations.UmrahOperations.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"Wallet_Master_View\"")
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WM_ID", nullable = false)
    private Long id;

    @Column(name = "TRANS_DATE", length = 10)
    private String transDate;

    @Column(name = "EA_CODE", precision = 10)
    private Long eaCode;

    @Column(name = "ACC_NAME_LA", length = 100)
    private String accountNameLa;

    @Column(name = "ACC_NAME_AR", length = 100)
    private String accountNameAr;

    @Column(name = "VOUCHER_DATE", length = 10)
    private String voucherDate;

    @Column(name = "EM_REFERENCE", length = 50)
    private String reference;

    @Column(name = "EM_AMOUNT", precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "EM_PAYMENT_MODE", precision = 6)
    private Integer paymentMode;

    @Column(name = "LPM_NAME_LA", length = 100)
    private String paymentNameLa;

    @Column(name = "LPM_NAME_AR", length = 100)
    private String paymentNameAr;

    @Column(name = "EM_CURRENCY", precision = 6)
    private Integer currency;

    @Column(name = "LC_SHORT_CODE", length = 5)
    private String shortCode;

    @Column(name = "EM_NARRATION", length = 500)
    private String narration;

    @Column(name = "EM_FILE_NAME", length = 100)
    private String fileName;

    @Column(name = "WM_STATUS", precision = 2)
    private Integer status;

    @Column(name = "WS_NAME_LA", length = 50)
    private String statusNameLa;

    @Column(name = "WS_NAME_AR", length = 50)
    private String statusNameAr;

    @Column(name = "WM_BANK_ACCOUNT", precision = 10)
    private Long bankAccount;

    @Column(name = "BANK_NAME_LA", length = 100)
    private String bankNameLa;

    @Column(name = "BANK_NAME_AR", length = 100)
    private String bankNameAr;

    @Column(name = "WM_CREDIT_ACCOUNT", precision = 10)
    private Long creditAccount;

    @Column(name = "CREDIT_BANK_NAME_LA", length = 100)
    private String creditBankNameLa;

    @Column(name = "CREDIT_BANK_NAME_AR", length = 100)
    private String creditBankNameAr;

    @Column(name = "ENTITY_ID", precision = 10)
    private Long entityId;

    // Custom enum for Status
//    public enum WalletStatus {
//        PENDING(0),
//        APPROVED(1),
//        REJECTED(2);
//
//        private final int value;
//
//        WalletStatus(int value) {
//            this.value = value;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public static WalletStatus fromValue(int value) {
//            for (WalletStatus status : WalletStatus.values()) {
//                if (status.value == value) {
//                    return status;
//                }
//            }
//            throw new IllegalArgumentException("Invalid status value: " + value);
//        }
//    }
//
//    // Helper methods
//    public WalletStatus getWalletStatus() {
//        return status != null ? WalletStatus.fromValue(status) : null;
//    }
//
//    public void setWalletStatus(WalletStatus walletStatus) {
//        this.status = walletStatus != null ? walletStatus.getValue() : null;
//    }

    @PrePersist
    @PreUpdate
    protected void onBeforeSave() {
        if (transDate == null) {
            transDate = LocalDate.now().toString();
        }
    }
}