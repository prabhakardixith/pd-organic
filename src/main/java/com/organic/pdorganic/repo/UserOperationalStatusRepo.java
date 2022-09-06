package com.organic.pdorganic.repo;


import com.organic.pdorganic.entity.UserOperationalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserOperationalStatusRepo extends JpaRepository<UserOperationalStatus, Integer>
{

    @Query(value = "select * from user_operational_status ORDER BY id DESC LIMIT 10;",nativeQuery = true)
    List<UserOperationalStatus> getRecentTenStatusRecords();
}
