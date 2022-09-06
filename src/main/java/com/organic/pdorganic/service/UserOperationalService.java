package com.organic.pdorganic.service;

import com.organic.pdorganic.entity.UserOperationalStatus;
import com.organic.pdorganic.repo.UserOperationalStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

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
        userOperationalStatusRepo.saveAndFlush(userOperationalStatus);
    }
}
