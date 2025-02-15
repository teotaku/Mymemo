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

    public void CreatePost(PostDTO postDto, String userEmail) {


    }

    public void createPost(PostDTO postDTO) {



        Post post = Post.createFromDTO(postDTO.getTitle(),postDTO.getContent());




    }

    public PostDTO selectPost(Long id) {
        Post post = postRepository.findById(id);
        PostDTO postDTO = PostDTO.fromEntity(post);
        return postDTO;
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);

    }
}
