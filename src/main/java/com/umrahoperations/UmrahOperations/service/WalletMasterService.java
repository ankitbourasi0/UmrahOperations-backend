package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.dto.WalletMasterDTO;

import com.umrahoperations.UmrahOperations.model.WalletMaster;
import com.umrahoperations.UmrahOperations.repository.WalletMasterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Slf4j
@Service
@RequiredArgsConstructor
public class WalletMasterService {

    @Autowired
        private WalletMasterRepository walletMasterRepository;

    public WalletMaster createWalletMaster(WalletMaster walletMaster) {
        return walletMasterRepository.save(walletMaster);
    }

}
