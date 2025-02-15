//package com.Bymyselfmemomemo.memomemomm.Entity;
//
//
//import jakarta.persistence.Column;
//import jakarta.persistence.MappedSuperclass;
//import jakarta.persistence.PrePersist;
//import jakarta.persistence.PreUpdate;
//import lombok.Getter;
//
//import java.time.LocalDateTime;
//
//@MappedSuperclass
//@Getter
//public class BaseEntity {
//
//    @Column(updatable = false)
//    private LocalDateTime createdAt;
//
//    private LocalDateTime updatedAt;
//
//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
//
//}
