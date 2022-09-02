package com.organic.pdorganic;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;
    String userName;
    String emailId;

    User(int id,String name,String email){
        this.userId = id;
        this.userName = name;
        this.emailId = email;
    }
}
