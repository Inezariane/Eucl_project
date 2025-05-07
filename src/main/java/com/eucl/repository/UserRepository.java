package com.eucl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eucl.user.*;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByName(String name);
    User findByPhone(String phone);
    List<User> findByRole(Role role);
}
