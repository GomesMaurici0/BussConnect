package com.busconnect.repository;

import com.busconnect.entities.UserClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserClientJPA extends JpaRepository<UserClientEntity, UUID> {
    boolean existsByUsername(String username);
}
