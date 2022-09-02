package com.organic.pdorganic;

import lombok.Data;

@Data
public class User {
    int userId;
    String userName;
    String emailId;

    User(int id,String name,String email){
        this.userId = id;
        this.userName = name;
        this.emailId = email;
    }
}
