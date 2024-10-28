package com.umrahoperations.UmrahOperations.utils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CountryCode {
    @Id
    private Integer id;

    @Column(name = "VP_CURRENCY_ID", nullable = false)
    private int sourceId;
}
