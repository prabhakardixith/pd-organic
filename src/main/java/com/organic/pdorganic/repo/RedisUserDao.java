package com.organic.pdorganic.repo;

import com.organic.pdorganic.entity.RedisUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RedisUserDao
{
//    @Autowired
//    HashOperations operations;
    @Autowired
    RedisTemplate redisTemplate;

    private static final String key = "redisUser";


    public boolean saveRedisUser(RedisUser redisUser) throws Exception{
        try{
            redisTemplate.opsForHash().put(key,redisUser.getUserId().toString(),redisUser);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public List<RedisUser> getAllUsers(RedisUser user) throws Exception{
        return redisTemplate.opsForHash().values(key);
    }
}
