package com.umrahoperations.UmrahOperations.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PaymentModeDTO {

        @Id
        @Column(name = "LPM_ID")
        private Integer lpmId;
        @Column(name = "LPM_NAME_LA")
        private String lpmNameLa;
        @Column(name = "LPM_NAME_AR")
        private String lpmNameAr;
}
