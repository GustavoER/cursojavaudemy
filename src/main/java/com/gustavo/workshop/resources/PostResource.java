package com.gustavo.workshop.resources;

import com.gustavo.workshop.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostResource {

    private final PostService postService;
    @Autowired
    public PostResource(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }

}
