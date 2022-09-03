package com.organic.pdorganic.controller;

import com.organic.pdorganic.entity.User;
import com.organic.pdorganic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"https://pd-organic-react.herokuapp.com/","http://localhost:3000"})
public class userController
{
    @Autowired
    UserService userService ;

    @GetMapping("/user")
    public List<User> getAllUsers(){
//		System.out.println("get User");
        return userService.getAllUsers();
    }

    @GetMapping("/userById")
    public User getUserById(@RequestParam("id") int id){
//		System.out.println("get User");
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        User savedUser = userService.saveOrUpdate(user);
        return savedUser;
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
        User updateUser = userService.saveOrUpdate(user);
        return updateUser;
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam("id") int id){
//        System.out.println("deleteUser by id : "+id);
        userService.deleteUserById(id);
    }

}
