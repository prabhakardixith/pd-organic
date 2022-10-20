package com.organic.pdorganic.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class Users implements Serializable {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;
    String userName;
    String emailId;

    Users(int id,String name,String email){
        this.userId = id;
        this.userName = name;
        this.emailId = email;
    }
}
