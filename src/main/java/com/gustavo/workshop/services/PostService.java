package com.gustavo.workshop.services;

import com.gustavo.workshop.domain.Post;
import com.gustavo.workshop.repository.PostRepository;
import com.gustavo.workshop.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(Integer id){
        Post post = postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
        return post;
    }
}
