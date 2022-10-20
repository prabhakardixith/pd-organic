package com.organic.pdorganic.repo;

import com.organic.pdorganic.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {
}
