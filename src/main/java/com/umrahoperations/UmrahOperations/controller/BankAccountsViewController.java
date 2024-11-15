package com.umrahoperations.UmrahOperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umrahoperations.UmrahOperations.model.BankAccountsView;
import com.umrahoperations.UmrahOperations.service.BankAccountsViewService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/lookups")
@Slf4j
public class BankAccountsViewController {

	
	BankAccountsViewService	service;
	
	@Autowired
	public BankAccountsViewController(BankAccountsViewService service) {
		this.service = service;
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping("/bankAccounts/{entityId}")
	public ResponseEntity<?> getBankAccounts(@PathVariable Long entityId)
	{
		System.out.println("In....");
		try {
			List<BankAccountsView> list = service.getBankAccounts(entityId);
			//System.out.println(list);
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
		
	}
	
	
}
