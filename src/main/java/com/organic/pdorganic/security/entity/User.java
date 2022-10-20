package com.organic.pdorganic.security.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "AuthUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @Column(length = 60)
    private String password;
    private String role;
    private boolean enabled = false;

}
