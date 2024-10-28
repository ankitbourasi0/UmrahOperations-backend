package com.umrahoperations.UmrahOperations.dto;import lombok.Data;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Luk_Currency_View")
public class CurrencyDTO {
    @Id
    @Column(name = "lc_id")
    private Long lcId;

    @Column(name = "source_id")
    private Integer sourceId;  // Changed from String to Integer

    // Add other fields as needed, with appropriate @Column annotations
}