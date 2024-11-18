package com.example.ucuddit.controller;

import com.example.ucuddit.dto.PostDTO;
import com.example.ucuddit.interfaces.service.IPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    private IPostService postService;

    @PostMapping("/save/posts")
    public PostDTO createPost(@RequestBody PostDTO post) {
        return postService.createPost(post.getUser().getAuth0id(), post.getTitle(), post.getCommunity(), post.getContent());
    }

    @GetMapping("/posts")
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/postsByCommunity")
    public List<PostDTO> getAllPostsByCommunity(@RequestParam Integer community) {
        return postService.getAllPostByComunnity(community);
    }

    @GetMapping("/postByTitle")
    public List<PostDTO> getPostByTitle(@RequestParam String title) {
        return postService.getPostByTitle(title);
    }

    @GetMapping("/postsByUser")
    public List<PostDTO> getAllPostByUser(@RequestParam String auth0id) {
        return postService.getAllPostByUserauth0id(auth0id);
    }

    @GetMapping("/postById")
    public PostDTO getPostById(@RequestParam Integer postId) {
        return postService.getPostById(postId);
    }
}
