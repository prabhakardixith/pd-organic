package com.organic.pdorganic.controller;

import com.organic.pdorganic.entity.RedisUser;
import com.organic.pdorganic.repo.RedisUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisUserController
{
    @Autowired
    RedisUserDao redisUserDao;

    @PostMapping("/user")
    public ResponseEntity<?> saveRedisUser(@RequestBody RedisUser user) throws Exception{
        boolean res = redisUserDao.saveRedisUser(user);
        if(res){
            return ResponseEntity.ok("User Created Successfully");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/user")
    public ResponseEntity<?> getAllUsers(@RequestBody RedisUser user) throws Exception {
         List<RedisUser> users = redisUserDao.getAllUsers(user);
         return ResponseEntity.ok(users);
    }


}
