package com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.controllers;

import com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.dto.PostDto;
import com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping(path = "/{postId}")
    public PostDto getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    @PostMapping
    public PostDto createNewPost(@RequestBody PostDto inputPost){
        return postService.createNewPost(inputPost);
    }
}
