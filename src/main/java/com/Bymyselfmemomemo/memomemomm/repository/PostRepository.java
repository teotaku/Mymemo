package com.Bymyselfmemomemo.memomemomm.repository;

import com.Bymyselfmemomemo.memomemomm.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findByUserEmail(String userEmail);

    Post findById(Long id);
}
