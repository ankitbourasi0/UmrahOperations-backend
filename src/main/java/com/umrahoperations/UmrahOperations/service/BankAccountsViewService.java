package com.umrahoperations.UmrahOperations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umrahoperations.UmrahOperations.model.BankAccountsView;
import com.umrahoperations.UmrahOperations.repository.BankAccountsViewRepository;

@Service
public class BankAccountsViewService {
	
	
	
	BankAccountsViewRepository		repository;
	
	@Autowired
	public BankAccountsViewService(BankAccountsViewRepository		repository) {
		this.repository = repository;
	}

	public List<BankAccountsView> getBankAccounts(Long entityId)
	{
		return repository.findByEaCode(entityId);
	}
}
