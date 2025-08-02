package com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.services;

import com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {

    List<PostDto> getAllPosts();

    PostDto createNewPost(PostDto inputPost);

    PostDto getPostById(Long postId);
}
