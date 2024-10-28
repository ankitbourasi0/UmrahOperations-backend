package com.umrahoperations.UmrahOperations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "v_countries")
public class Country {

    @Id
    private Integer countryCode;
    private String countryName;

    public Country(Integer countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public Country() {

    }

    // Getters and setters
    public Integer getCountryCode() { return countryCode; }
    public void setCountryCode(Integer countryCode) { this.countryCode = countryCode; }
    public String getCountryName() { return countryName; }
    public void setCountryName(String countryName) { this.countryName = countryName; }
}