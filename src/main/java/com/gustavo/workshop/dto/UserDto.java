package com.gustavo.workshop.dto;


import com.gustavo.workshop.domain.Post;
import com.gustavo.workshop.domain.User;
import com.gustavo.workshop.repository.PostRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
@Setter
public class UserDto implements Serializable {
    private static final long serialVersionUID = -7090583085521105816L;
    private Integer id;
    private String name;
    private String email;
    private List<PostDTO> posts = new ArrayList<>();

    public UserDto(User obj, List<Post> posts) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.posts.addAll(posts.stream()
                .map(post -> {
                    return new PostDTO(post.getId(), post.getTitle(), post.getBody());
                }).collect(Collectors.toList()));
    }

    public UserDto(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
    }

}
