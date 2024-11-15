package com.umrahoperations.UmrahOperations.controller;

import com.umrahoperations.UmrahOperations.model.WalletTransaction;
import com.umrahoperations.UmrahOperations.service.WalletTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class WalletAccountController {

    @Autowired
    private WalletTransactionService walletTransactionService;

    @GetMapping("/list/{eaCode}")
    public ResponseEntity<?> getWalletAccountList(@PathVariable Long eaCode) {
        try {
           var walletList = walletTransactionService.getWalletAccountList(eaCode);
            return ResponseEntity.ok(walletList);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }



    }
}

