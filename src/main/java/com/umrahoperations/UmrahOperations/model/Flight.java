package com.umrahoperations.UmrahOperations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Flight {
    @Id
    private Long sl;
    private String code;
    private String city;
    private String country;
    private String suggestName;
    private String shortCode;
}
