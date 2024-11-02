package com.umrahoperations.UmrahOperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.umrahoperations.UmrahOperations.model.BankAccountsView;
import com.umrahoperations.UmrahOperations.service.BankAccountsViewService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/lookups")
@Slf4j
public class BankAccountsViewController {

	
	
	
	BankAccountsViewService	service;
	
	@Autowired
	public BankAccountsViewController(BankAccountsViewService service) {
		this.service = service;
		// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping("/bankAccounts")
	public ResponseEntity<?> getBankAccounts()
	{
		try {
			List<BankAccountsView> list = service.getBankAccounts();
			
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
		
		
	}
	
	
}
