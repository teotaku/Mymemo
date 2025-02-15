package com.Bymyselfmemomemo.memomemomm.Entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String password;

    @Column
    private String role;

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
