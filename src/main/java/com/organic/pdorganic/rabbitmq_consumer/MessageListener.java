package com.organic.pdorganic.rabbitmq_consumer;

import com.organic.pdorganic.entity.UserOperationalStatus;
import com.organic.pdorganic.rabbitmq_producer.MqConfig;
import com.organic.pdorganic.repo.UserOperationalStatusRepo;
import com.organic.pdorganic.service.UserOperationalService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @Autowired
    UserOperationalService userOperationalStatusService;
    @RabbitListener(queues = MqConfig.QUEUE)
    public void listener(UserOperationalStatus message) throws Exception{

        userOperationalStatusService.addOperationalStatus(message);

    }
}
