package com.example.ucuddit.service;

import com.example.ucuddit.dto.PostDTO;
import com.example.ucuddit.interfaces.service.IPostService;
import com.example.ucuddit.mapper.PostMapper;
import com.example.ucuddit.model.Post;
import com.example.ucuddit.model.Rate;
import com.example.ucuddit.model.User;
import com.example.ucuddit.respository.PostRepository;
import com.example.ucuddit.respository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ucuddit.respository.UserRepository;


import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private RateRepository rateRepository;
    private static final PostMapper postMapper = PostMapper.INSTANCE;

    public PostDTO getPostById(Integer postId) {
        Post post = postRepository.findById(postId).orElse(null);
        if (post == null) {
            return null;
        }
        return postMapper.postToPostDTO(post);
    }

    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        if (posts.isEmpty()) {
            throw new IllegalArgumentException("No posts found for the specified user.");
        }

        return posts.stream().map(postMapper::postToPostDTO).toList();
    }

    public List<PostDTO> getAllPostByUserauth0id(String auth0id) {
        List<Post> posts = postRepository.findByUser_auth0id(auth0id);

        if (posts.isEmpty()) {
            throw new IllegalArgumentException("No posts found for the specified user.");
        }

        return posts.stream().map(postMapper::postToPostDTO).toList();
    }

    public List<PostDTO> getAllPostByComunnity(Integer community) {
        List<Post> posts = postRepository.findBycommunity(community);

        if (posts.isEmpty()) {
            throw new IllegalArgumentException("No posts found for the specified community.");
        }

        return posts.stream().map(postMapper::postToPostDTO).toList();
    }

    public List<PostDTO> getPostByTitle(String title) {
        List<Post> posts = postRepository.findByTitleContainingIgnoreCase(title);

        if (posts.isEmpty()) {
            throw new IllegalArgumentException("No posts found for the specified user.");
        }

        return posts.stream().map(postMapper::postToPostDTO).toList();
    }

    public List<PostDTO> getPostsByUserAndLikes(String auth0id, Integer likes) {
        if (likes == null) {
            throw new IllegalArgumentException("The likes value cannot be null.");
        }
        List<Post> posts = rateRepository.findPostsByAuth0idAndLikes(auth0id, likes);
        return posts.stream()
                .map(postMapper::postToPostDTO).toList();
    }

    public PostDTO createPost(String auth0id, String title, Integer community, String content) {
        User existingUser = userRepository.findByauth0id(auth0id);

        if (existingUser == null) {
            throw new IllegalArgumentException("No user found with the specified auth0id.");
        }

        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setCommunity(community);
        newPost.setUser(existingUser);
        newPost.setContent(content);
        newPost.setCreatedAt(LocalDate.now());
        postRepository.save(newPost);
        return postMapper.postToPostDTO(newPost);
    }
}
