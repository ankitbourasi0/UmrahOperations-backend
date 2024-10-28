package com.umrahoperations.UmrahOperations.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MenuDTO {
    private String name;
    private String headerName;  // This will store the name of the parent header

    public MenuDTO(String name, String headerName) {
        this.name = name;
        this.headerName = headerName;
    }

    // Constructor, getters, and setters
}