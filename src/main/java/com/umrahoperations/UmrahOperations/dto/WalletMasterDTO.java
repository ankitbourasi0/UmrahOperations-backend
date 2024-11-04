package com.umrahoperations.UmrahOperations.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class WalletMasterDTO {
    private Long wmId;
    private Date wmDate;
    private int wmAgentId;
    private Date emVoucherDate;
    private String emReference;
    private double emAmount;
    private int emPaymentMode;
    private Long emCurrency;
    private String emNarration;
    private String emFileName;
    private Date emEdate;
    private Long emEuser;
    private int wmStatus;
    private Long wmBankAccount;
    private Long wmCreditAccount;
    private Long wmEntityId;
}
