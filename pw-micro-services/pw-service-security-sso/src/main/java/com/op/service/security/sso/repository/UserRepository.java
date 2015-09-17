package com.op.service.security.sso.repository;

import com.op.service.security.sso.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Long id);
    User findByUsername(String username);
}