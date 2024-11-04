package com.umrahoperations.UmrahOperations.service;

import java.util.List;

import com.umrahoperations.UmrahOperations.utils.EmptyListException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umrahoperations.UmrahOperations.model.BankAccountsView;
import com.umrahoperations.UmrahOperations.repository.BankAccountsViewRepository;

@Service
public class BankAccountsViewService {


	private static final Logger log = LoggerFactory.getLogger(BankAccountsViewService.class);
	BankAccountsViewRepository		repository;
	
	@Autowired
	public BankAccountsViewService(BankAccountsViewRepository		repository) {
		this.repository = repository;
	}

	public List<BankAccountsView> getBankAccounts(Long entityId) throws EmptyListException
	{
		log.info("getBankAccounts Fetching with: {}", entityId);
		var bankAccount  = repository.findByEaCode(entityId);
					if (bankAccount.isEmpty()){
						throw new EmptyListException("Bank Account not Found");
					}
		log.info("bank account list with size {}", bankAccount.size());

		return bankAccount;

		}
}
