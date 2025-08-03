package com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.services;

import com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.dto.PostDto;
import com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.entities.PostEntity;
import com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.exceptions.ResourceNotFoundException;
import com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.respositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto createNewPost(PostDto inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        PostEntity newPostEntity = postRepository.save(postEntity);
        return modelMapper.map(newPostEntity, PostDto.class);
    }

    @Override
    public PostDto getPostById(Long postId) {
        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));

        return modelMapper.map(postEntity, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto inputPost, Long postId) {
        PostEntity olderPost = postRepository
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));

        inputPost.setId(postId);
        modelMapper.map(inputPost, olderPost);
        PostEntity savedPostEntity = postRepository.save(olderPost);
        return modelMapper.map(savedPostEntity, PostDto.class);
    }
}
