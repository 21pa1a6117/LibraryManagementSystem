package com.example.library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user") // avoid conflict with "user" keyword
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    // getters and setters
}
