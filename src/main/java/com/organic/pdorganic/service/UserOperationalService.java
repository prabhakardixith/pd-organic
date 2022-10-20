package com.organic.pdorganic.service;

import com.organic.pdorganic.entity.UserOperationalStatus;
import com.organic.pdorganic.repo.UserOperationalStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<UserOperationalStatus> getUserOperationalStatusRepo(int pageNumber) throws Exception{
        PageRequest of = PageRequest.of(pageNumber, 10);
        return userOperationalStatusRepo.findTop10ByOrderByIdDesc(of);

    }

//    @CacheEvict(value = "userOperationalStatus",allEntries = true)
    public void addOperationalStatus(UserOperationalStatus userOperationalStatus) throws Exception{

            userOperationalStatusRepo.saveAndFlush(userOperationalStatus);

    }
}
