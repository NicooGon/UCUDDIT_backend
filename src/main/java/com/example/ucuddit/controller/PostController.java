package com.example.ucuddit.controller;

import com.example.ucuddit.model.Post;
import com.example.ucuddit.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/save/posts")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post.getUser().getAuth0id(), post.getTitle(), post.getContent());
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/postsByUser")
    public List<Post> getAllPostByUser(@RequestParam String name) {
        return postService.getAllPostByUsername(name);
    }

    @GetMapping("/postById")
    public Post getPostById(@RequestParam Integer postId) {
        return postService.getPostById(postId);
    }
}
