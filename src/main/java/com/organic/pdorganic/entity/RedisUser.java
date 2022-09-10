package com.organic.pdorganic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@RedisHash
public class RedisUser implements Serializable
{
    Integer userId;
    String userName;
    String emailId;
}
