package com.organic.pdorganic.repo;


import com.organic.pdorganic.entity.UserOperationalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOperationalStatusRepo extends JpaRepository<UserOperationalStatus, Integer> {
}
