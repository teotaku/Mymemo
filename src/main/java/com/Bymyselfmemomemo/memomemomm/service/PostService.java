package com.Bymyselfmemomemo.memomemomm.service;

import com.Bymyselfmemomemo.memomemomm.Entity.Post;
import com.Bymyselfmemomemo.memomemomm.Entity.UserEntity;
import com.Bymyselfmemomemo.memomemomm.dto.PostDTO;
import com.Bymyselfmemomemo.memomemomm.repository.PostRepository;
import com.Bymyselfmemomemo.memomemomm.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<PostDTO> getAllPosts() {
        List<Post> all = postRepository.findAll();
        return all.stream().map(PostDTO::fromEntity).collect(Collectors.toList());


    }



    public void createPost(PostDTO postDTO) {




    }

    public PostDTO selectPost(Long id) {
       Post post = postRepository.findById(id).orElseThrow
               (()->new RuntimeException("찾을 수 없습니다."));

        return PostDTO.fromEntity(post);

    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);

    }
}
