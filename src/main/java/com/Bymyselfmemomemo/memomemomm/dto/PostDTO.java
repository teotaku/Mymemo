package com.Bymyselfmemomemo.memomemomm.dto;

import com.Bymyselfmemomemo.memomemomm.Entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostDTO {

    String title;
    String content;



    public static PostDTO fromEntity(Post post) {
        return new PostDTO(post.getTitle(), post.getContent());
    }
}
