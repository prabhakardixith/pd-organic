package com.organic.pdorganic.rabbitmq_producer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomMessage {
    private String messageId;
    private String userId;
    private String message;
    private Date messageDate;

}
