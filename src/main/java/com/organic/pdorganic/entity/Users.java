package com.organic.pdorganic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users implements Serializable {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;
    String userName;
    String emailId;

    String phoneNo;

    String address;

}
