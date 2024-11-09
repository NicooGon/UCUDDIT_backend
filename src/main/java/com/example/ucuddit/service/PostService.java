package com.example.ucuddit.service;

import com.example.ucuddit.model.Comment;
import com.example.ucuddit.model.Post;
import com.example.ucuddit.model.User;
import com.example.ucuddit.respository.PostRepository;
import org.springframework.stereotype.Service;
import com.example.ucuddit.respository.UserRepository;


import java.time.LocalDate;
import java.util.List;

@Service
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Post getPostById(Integer postId) {
        return postRepository.findBypostId(postId);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> getAllPostByUsername(String name) {
        return postRepository.findByUser_Name(name);
    }

    public Post createPost(String auth0id, String title, String content) {
        User existingUser = userRepository.findByauth0id(auth0id);

        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setUser(existingUser);
        newPost.setContent(content);
        newPost.setCreatedAt(LocalDate.now());
        return postRepository.save(newPost);
    }
}
