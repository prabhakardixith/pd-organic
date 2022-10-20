package com.organic.pdorganic.controller;

import com.organic.pdorganic.entity.UserOperationalStatus;
import com.organic.pdorganic.rabbitmq_producer.MqConfig;
import com.organic.pdorganic.repo.UserOperationalStatusRepo;
import com.organic.pdorganic.service.UserOperationalService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserOperationalStatusControl {
    @Autowired
    UserOperationalService  userOperationalService;

    @Autowired
    RabbitTemplate template;

    @GetMapping("/user/operational")
    public Page<UserOperationalStatus> allUSerOperationalStatus(@RequestParam("pageNo") int pageNumber) throws Exception{
        System.out.println("pageNumber : "+pageNumber);
        return userOperationalService.getUserOperationalStatusRepo(pageNumber);
    }
}
