package com.organic.pdorganic.service;

import com.organic.pdorganic.entity.UserOperationalStatus;
import com.organic.pdorganic.repo.UserOperationalStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class UserOperationalService
{
    @Autowired
    UserOperationalStatusRepo userOperationalStatusRepo ;

//    @Cacheable(value = "userOperationalStatus")
    public List<UserOperationalStatus> getUserOperationalStatusRepo() throws Exception{
       return userOperationalStatusRepo.getRecentTenStatusRecords();
    }

//    @CacheEvict(value = "userOperationalStatus",allEntries = true)
    public void addOperationalStatus(UserOperationalStatus userOperationalStatus) throws Exception{
        long count = userOperationalStatusRepo.findAll().stream().count();
        if(count >= 10){
            List<UserOperationalStatus> collect = userOperationalStatusRepo.findAll().stream().sorted(Comparator.comparingInt(UserOperationalStatus::getId)).limit(9).collect(Collectors.toList());
            collect.add(userOperationalStatus);
            List<UserOperationalStatus> deleted = userOperationalStatusRepo.getRecentTenStatusRecords().stream().collect(Collectors.toList());
            userOperationalStatusRepo.deleteAll(deleted);
            for (UserOperationalStatus userStatus : collect) {
                userOperationalStatusRepo.save(userStatus);
            }
        }
        else{
            userOperationalStatusRepo.saveAndFlush(userOperationalStatus);
        }
    }
}
