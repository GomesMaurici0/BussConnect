package com.busconnect.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class UserClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userid;
    private String name;
    private String username;
    private String password;
}
