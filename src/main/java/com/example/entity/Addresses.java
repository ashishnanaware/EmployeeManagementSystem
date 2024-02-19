package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "address")
public class Addresses {
    @Id
    private String id;
    @Column(name = "employee_id")
    private String employee_id;
    private String AddressLine1;
    private String AddressLine2;
    private String City;
    private String State;
    private String PostalCode;
    private String country;


}
