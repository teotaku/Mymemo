package com.Bymyselfmemomemo.memomemomm.Entity;

import com.Bymyselfmemomemo.memomemomm.dto.PostDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
public class Post {


    // private 생성자로 외부에서 직접 객체 생성을 막음
    protected Post() {}


    public Post(PostDTO postDTO) {
        this.content = postDTO.getContent();
        this.title = postDTO.getTitle();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String title;


    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder
    private Post(String title, String content, UserEntity userEntity) {
        this.title = title;
        this.content = content;
        this.userEntity = userEntity;
    }

    // 정적 팩토리 메서드 추가
    public static Post createFromDTO(PostDTO postDTO,UserEntity userEntity) {
        return Post.builder()
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .userEntity(userEntity)
                .build();
     }
}


