package com.umrahoperations.UmrahOperations.controller;

import com.umrahoperations.UmrahOperations.dto.PaymentModeDTO;
import com.umrahoperations.UmrahOperations.model.Wallet;
import com.umrahoperations.UmrahOperations.service.WalletSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    @Autowired
    private WalletSerive walletSerive;

    @GetMapping("/{entityId}")
    public List<Wallet> GetBankDetail(@PathVariable Long entityId) throws Exception {

        return walletSerive.getWallet(entityId);

    }


}
