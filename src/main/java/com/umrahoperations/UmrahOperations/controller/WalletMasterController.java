package com.umrahoperations.UmrahOperations.controller;

import com.umrahoperations.UmrahOperations.dto.WalletMasterDTO;
import com.umrahoperations.UmrahOperations.model.WalletMaster;
import com.umrahoperations.UmrahOperations.service.WalletMasterService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wallets")
@RequiredArgsConstructor
public class WalletMasterController {
    private static final Logger log = LoggerFactory.getLogger(WalletMasterController.class);
    @Autowired
    private  WalletMasterService walletMasterService;


    @PostMapping
    public ResponseEntity<WalletMaster> createWalletMaster(@RequestBody WalletMasterDTO walletMasterDto) {
        WalletMaster walletMaster = WalletMaster.builder()
                .wmId(walletMasterDto.getWmId())
                .wmDate(walletMasterDto.getWmDate())
                .wmAgentId(walletMasterDto.getWmAgentId())
                .emVoucherDate(walletMasterDto.getEmVoucherDate())
                .emReference(walletMasterDto.getEmReference())
                .emAmount(walletMasterDto.getEmAmount())
                .emPaymentMode(walletMasterDto.getEmPaymentMode())
                .emCurrency(walletMasterDto.getEmCurrency())
                .emNarration(walletMasterDto.getEmNarration())
                .emFileName(walletMasterDto.getEmFileName())
                .emEdate(walletMasterDto.getEmEdate())
                .emEuser(walletMasterDto.getEmEuser())
                .wmStatus(walletMasterDto.getWmStatus())
                .wmBankAccount(walletMasterDto.getWmBankAccount())
                .wmCreditAccount(walletMasterDto.getWmCreditAccount())
                .wmEntityId(walletMasterDto.getWmEntityId())
                .build();

        WalletMaster savedWalletMaster = walletMasterService.createWalletMaster(walletMaster);
        return ResponseEntity.ok(savedWalletMaster);
    }
}
