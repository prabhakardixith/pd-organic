package com.organic.pdorganic.repo;

import com.organic.pdorganic.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
