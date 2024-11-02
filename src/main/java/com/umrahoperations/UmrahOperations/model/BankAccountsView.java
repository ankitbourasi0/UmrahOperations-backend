package com.umrahoperations.UmrahOperations.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"Bank_Accounts_View\"")
public class BankAccountsView {

	
	@Id
	@Column(name = "BA_ID")
	private Long baId;
	
	@Column(name = "BANK_NAME")
	private String bankName;

	@Column(name = "BA_ACCOUNT_NO")
	private String accountNo;
	
	@Column(name = "BA_ADDRESS")
	private String address;
	
	@Column(name="BA_IBAN")
	private String iban;
	
	@Column(name = "BA_SWIFT_CODE")
	private String swiftCode;
	
	@Column(name = "BA_STATUS")
	private Integer status;
	
	@Column(name = "ENTITY_ID")
	private String entityId;
	
}
