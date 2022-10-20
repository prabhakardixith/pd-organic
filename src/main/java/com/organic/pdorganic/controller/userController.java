package com.organic.pdorganic.controller;

import com.organic.pdorganic.entity.UserOperationalStatus;
import com.organic.pdorganic.entity.Users;
import com.organic.pdorganic.rabbitmq_producer.MqConfig;
import com.organic.pdorganic.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
//@RequestMapping("normal/")
@CrossOrigin(origins = {"https://pd-organic-react.herokuapp.com/","http://localhost:3000"})
public class userController
{
    @Autowired
    UserService userService ;

    @Autowired
    RabbitTemplate template;

    @GetMapping("/user")
    public List<Users> getAllUsers()throws Exception{
        return userService.getAllUsers();
    }

    @GetMapping("/userById")
    public Users getUserById(@RequestParam("id") int id)throws Exception{
        template.convertAndSend(MqConfig.EXCHANGE,MqConfig.Routing_Key,new UserOperationalStatus(0,UUID.randomUUID().toString(),""+id,"Requested for specific user by Id",new Date()));
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public Users addUser(@RequestBody Users user)throws Exception{
        Users savedUser = userService.saveOrUpdate(user);
        template.convertAndSend(MqConfig.EXCHANGE,MqConfig.Routing_Key,new UserOperationalStatus(0,UUID.randomUUID().toString(),user.getEmailId(),"new User created",new Date()));
        return savedUser;
    }

    @PutMapping("/user")
    public Users updateUser(@RequestBody Users user)throws Exception{
        Users updateUser = userService.saveOrUpdate(user);
        template.convertAndSend(MqConfig.EXCHANGE,MqConfig.Routing_Key,new UserOperationalStatus(0,UUID.randomUUID().toString(),""+user.getUserId(),"User Updated",new Date()));
        return updateUser;
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam("id") int id)throws Exception{
//        System.out.println("deleteUser by id : "+id);
        template.convertAndSend(MqConfig.EXCHANGE,MqConfig.Routing_Key,new UserOperationalStatus(0,UUID.randomUUID().toString(),""+id,"User Deleted",new Date()));
        userService.deleteUserById(id);
    }



}
