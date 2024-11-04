package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.dto.PaymentModeDTO;
import com.umrahoperations.UmrahOperations.model.Wallet;
import com.umrahoperations.UmrahOperations.repository.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WalletSerive {

    @Autowired
    private WalletRepository walletRepository;
    private  static  final Logger logger = LoggerFactory.getLogger(WalletSerive.class);
    public List<Wallet> getWallet(Long entityId) throws Exception {

        try{
            logger.info("Entity Id {}", entityId );
        List<Wallet> walletList =  walletRepository.getByEntityID(entityId);
        return walletList;
        }catch (Exception e){
            throw new Exception("List Not Found");
        }


    }




}
