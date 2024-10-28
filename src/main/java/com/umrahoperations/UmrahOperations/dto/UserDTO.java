package com.umrahoperations.UmrahOperations.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private String username;
    private String status;
    private List<HeaderDTO> headers;
    private Integer countryCode;
    private Long agentCode;
    private int agentCurrency;
    private Long vrId;

    public void setVrId(Long vrId) {
        this.vrId = vrId;
    }

    public void setAgentCurrency(int agentCurrency) {
        this.agentCurrency = agentCurrency;
    }

    public void setAgentCode(Long agentCode) {
        this.agentCode = agentCode;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHeaders(List<HeaderDTO> headers) {
        this.headers = headers;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
// Constructor, getters, and setters
}