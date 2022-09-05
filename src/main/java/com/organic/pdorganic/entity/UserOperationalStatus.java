package com.organic.pdorganic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOperationalStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String queueMessageId;
    private String userId;
    private String message;
    private Date messageDate;
}
