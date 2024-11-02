package com.umrahoperations.UmrahOperations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umrahoperations.UmrahOperations.model.BankAccountsView;
import com.umrahoperations.UmrahOperations.repository.BankAccountsViewRepository;

@Service
public class BankAccountsViewService {
	
	
	@Autowired
	BankAccountsViewRepository		repository;
	
	public BankAccountsViewService(BankAccountsViewRepository		repository) {
		this.repository = repository;
	}

	public List<BankAccountsView> getBankAccounts()
	{
		return repository.findAll();
	}
}
