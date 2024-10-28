package com.umrahoperations.UmrahOperations.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class VisaFollowupDTO {

    private int withAgent;

    private int withCompany;

    private int payment;

    private int approved;

    private int rejected;

    private int gotVisa;

}
