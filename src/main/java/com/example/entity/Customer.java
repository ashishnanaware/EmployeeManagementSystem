package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
}