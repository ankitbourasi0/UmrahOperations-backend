package com.umrahoperations.UmrahOperations.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ExtraVisaPriceDTO {

    @Id
    @Column(name="SOURCE_ID")
   private int source_id;
    @Column(name="LC_ID")
   private int lc_id;
    @Column(name="LC_NAME_LA")
   private String lc_name_la;
    @Column(name="LC_NAME_AR")
   private String lc_name_ar;
    @Column(name="SOURCE_SHORT_CODE")
   private String source_short_code ;
    @Column(name="LC_SHORT_CODE")
   private String lc_short_code;
    @Column(name="LC_STATUS")
   private int lc_status;
    @Column(name="TARGET_STATUS")
   private int target_status;
    @Column(name="TODAYS_RATE")
   private Double todays_rate;
}