package com.organic.pdorganic.security;

import com.organic.pdorganic.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryForSecurity extends JpaRepository<User,Long> {
}
