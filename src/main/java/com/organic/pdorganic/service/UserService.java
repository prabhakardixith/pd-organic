package com.organic.pdorganic.service;

import com.organic.pdorganic.entity.User;
import com.organic.pdorganic.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService
{
    @Autowired
    UserRepo userRepo ;

    @Cacheable(value = "user")
    public List<User> getAllUsers(){
//        System.out.println("getAllUser()");
        return userRepo.findAll();
    }

//    @Cacheable(cacheNames = "user",key = "#user.userId")
    public User getUserById(int id){
//        System.out.println("getUserId()");
        return userRepo.findById(id).get();
    }

    @CacheEvict(value = "user",allEntries = true)
    public User saveOrUpdate(User user) {
//        System.out.println("saveOrUpdate()");
        return userRepo.saveAndFlush(user);
    }

    @CacheEvict(value = "user",allEntries = true)
    public void deleteUserById(int id) {
//        System.out.println("deleteUserById()");
        userRepo.deleteById(id);
    }

}
