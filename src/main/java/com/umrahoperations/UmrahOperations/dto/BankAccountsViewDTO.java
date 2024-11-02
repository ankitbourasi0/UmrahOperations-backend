package com.umrahoperations.UmrahOperations.dto;

import lombok.Data;

@Data
public class BankAccountsViewDTO {

	
	   private Long   baId;
	   private String bankName;
	   private String accountNo;
	   private String address;
	   private String iban;
	   private String swiftCode;
	   private String status;
	   private Long   entityId;
}
