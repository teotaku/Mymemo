package com.Bymyselfmemomemo.memomemomm.Controller;


import com.Bymyselfmemomemo.memomemomm.Entity.Post;
import com.Bymyselfmemomemo.memomemomm.dto.PostDTO;
import com.Bymyselfmemomemo.memomemomm.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/list")
    public List<PostDTO> findAllPosts() {
        return postService.getAllPosts();

    }

    @PostMapping("/create")
    public String createPost(PostDTO postDTO) {
        postService.createPost(postDTO);//로그인된유저정보 빼내는거 필요 jwt
        return "완료";
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
       return  "삭제 완료";
    }


    @GetMapping("/list/{id}")
    public PostDTO selectPost(@PathVariable Long id) {
        PostDTO postDTO = postService.selectPost(id);
        return postDTO;
    }
}
