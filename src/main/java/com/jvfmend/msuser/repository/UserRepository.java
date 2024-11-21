package com.jvfmend.msuser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvfmend.msuser.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByLogin(String login);
}
