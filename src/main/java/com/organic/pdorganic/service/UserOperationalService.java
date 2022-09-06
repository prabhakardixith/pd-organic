package com.organic.pdorganic.service;

import com.organic.pdorganic.entity.UserOperationalStatus;
import com.organic.pdorganic.repo.UserOperationalStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class UserOperationalService
{
    @Autowired
    UserOperationalStatusRepo userOperationalStatusRepo ;

//    @Cacheable(value = "userOperationalStatus")
    public List<UserOperationalStatus> getUserOperationalStatusRepo() {
       return userOperationalStatusRepo.getRecentTenStatusRecords();
    }

//    @CacheEvict(value = "userOperationalStatus",allEntries = true)
    public void addOperationalStatus(UserOperationalStatus userOperationalStatus) {
        long count = userOperationalStatusRepo.findAll().stream().count();
        if(count >= 10){
            List<UserOperationalStatus> collect = userOperationalStatusRepo.getRecentTenStatusRecords().stream().limit(9).collect(Collectors.toList());
            collect.add(userOperationalStatus);
            List<UserOperationalStatus> remove = userOperationalStatusRepo.findAll();
            userOperationalStatusRepo.deleteAll(remove);
            userOperationalStatusRepo.saveAll(collect);
        }
        else{
            userOperationalStatusRepo.saveAndFlush(userOperationalStatus);
        }
    }
}
