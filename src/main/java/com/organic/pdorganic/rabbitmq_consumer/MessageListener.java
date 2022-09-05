package com.organic.pdorganic.rabbitmq_consumer;

import com.organic.pdorganic.entity.UserOperationalStatus;
import com.organic.pdorganic.rabbitmq_producer.MqConfig;
import com.organic.pdorganic.repo.UserOperationalStatusRepo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @Autowired
    UserOperationalStatusRepo userOperationalStatusRepo;
    @RabbitListener(queues = MqConfig.QUEUE)
    public void listener(UserOperationalStatus message) {
        userOperationalStatusRepo.save(message);
        System.out.println("rabbit mq consumer : "+message);
    }
}
