package com.Bymyselfmemomemo.memomemomm.Entity;


import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "userEntity_id")
    private UserEntity userEntity;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void OnCreate() {
        this.createdAt = LocalDateTime.now();
    }

}
