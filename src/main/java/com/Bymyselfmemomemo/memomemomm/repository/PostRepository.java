package com.Bymyselfmemomemo.memomemomm.repository;

import com.Bymyselfmemomemo.memomemomm.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findByUserEntity_UserEmail(String userEmail);

    Optional<Post> findById(Long id);
}
