package com.organic.pdorganic.controller;

import com.organic.pdorganic.entity.RedisUser;
import com.organic.pdorganic.repo.RedisUserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class RedisUserController
{
    @Autowired
    RedisUserDao redisUserDao;

    @PostMapping("/redis/user")
    public ResponseEntity<?> saveRedisUser(@RequestBody RedisUser user) throws Exception{
        boolean res = redisUserDao.saveRedisUser(user);
        if(res){
            return ResponseEntity.ok("User Created Successfully");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/redis/user")
    public ResponseEntity<?> getAllUsers() throws Exception {
        log.info("inside redis getAllUsers()");
         List<RedisUser> users = redisUserDao.getAllUsers();
         log.info("users : "+users);
         return ResponseEntity.ok(users);
    }


}
