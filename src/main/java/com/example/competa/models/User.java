package com.example.competa.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // идентификатор
    private String user_name;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String zip;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateOfBirth;

}
