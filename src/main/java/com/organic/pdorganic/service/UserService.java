package com.organic.pdorganic.service;

import com.organic.pdorganic.entity.User;
import com.organic.pdorganic.entity.UserOperationalStatus;
import com.organic.pdorganic.rabbitmq_producer.MqConfig;
import com.organic.pdorganic.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class UserService
{
    @Autowired
    UserRepo userRepo ;

    @Autowired
    RabbitTemplate template;

    @Cacheable(value = "user")
    public List<User> getAllUsers(){
//        template.convertAndSend(MqConfig.EXCHANGE,MqConfig.Routing_Key,new UserOperationalStatus(0, UUID.randomUUID().toString(),"","Requested for all users",new Date()));
        return userRepo.findAll();
    }

//    @Cacheable(cacheNames = "user",key = "#user.userId")
    public User getUserById(int id){
        return userRepo.findById(id).get();
    }

    @CacheEvict(value = "user",allEntries = true)
    public User saveOrUpdate(User user) {
        return userRepo.saveAndFlush(user);
    }

    @CacheEvict(value = "user",allEntries = true)
    public void deleteUserById(int id) {
        userRepo.deleteById(id);
    }

}
