package com.umrahoperations.UmrahOperations.service;

import com.umrahoperations.UmrahOperations.model.WalletTransaction;
import com.umrahoperations.UmrahOperations.repository.WalletTransactionRepository;
import com.umrahoperations.UmrahOperations.utils.EmptyListException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletTransactionService {

    @Autowired
    private WalletTransactionRepository walletTransactionRepository;
    private static final Logger logger = LoggerFactory.getLogger(WalletTransactionService.class);
    public  List<WalletTransaction> getWalletAccountList(Long eaCode) throws EmptyListException {
        logger.info("Fetching all wallet transactions");
       List<WalletTransaction> walletAccountList =  walletTransactionRepository.findAllWithNativeQuery(eaCode);
        if (walletAccountList.isEmpty()){
            throw new EmptyListException("WalletAccountList is Empty");
        }
        logger.info("fetched all wallet transactions with size {}", walletAccountList.size());

        return walletAccountList;
    }
}
