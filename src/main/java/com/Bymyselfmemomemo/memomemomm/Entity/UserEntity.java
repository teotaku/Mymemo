package com.Bymyselfmemomemo.memomemomm.Entity;


import com.Bymyselfmemomemo.memomemomm.dto.JoinDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.apache.catalina.User;

import java.time.LocalDateTime;

@Builder
@Getter
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


    private LocalDateTime createdAt ;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }



    public static UserEntity createFromDTO(JoinDTO joinDTO,String encodePassword) {
        return UserEntity.builder()
                .userEmail(joinDTO.getUsername())
                .password(encodePassword)
                .role("ROLE_ADMIN")
                .build();
    }
}
