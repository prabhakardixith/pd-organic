package com.organic.pdorganic.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
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
