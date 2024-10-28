package com.umrahoperations.UmrahOperations.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
@Entity
@Table(name = "\"LoginPrevs\"")  // Exact match with database, including quotes
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")  // Exact match with database column name
    private Long id;

    @Column(name = "USER_LOGIN",nullable = false,unique = true)
    private String emailId;

    @Column(name = "USER_PASS",nullable = false)
    private String password;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
