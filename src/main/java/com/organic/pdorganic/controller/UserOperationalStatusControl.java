package com.organic.pdorganic.controller;

import com.organic.pdorganic.entity.UserOperationalStatus;
import com.organic.pdorganic.rabbitmq_producer.MqConfig;
import com.organic.pdorganic.repo.UserOperationalStatusRepo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserOperationalStatusControl {
    @Autowired
    UserOperationalStatusRepo userOperationalStatusRepo ;

    @Autowired
    RabbitTemplate template;

    @GetMapping("/user/operational")
    public List<UserOperationalStatus> allUSerOperationalStatus() {
        return userOperationalStatusRepo.findAll();
    }
}
