package com.umrahoperations.UmrahOperations.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SignInDTO {
        //the dto fields name and the postname body parameters should be same
        private String emailId;
        private String password;
        

}
