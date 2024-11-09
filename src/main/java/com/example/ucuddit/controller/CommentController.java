package com.example.ucuddit.controller;

import com.example.ucuddit.model.Comment;
import com.example.ucuddit.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/commentsByPost")
    public List<Comment> getAllCommentsByPost(@RequestParam Integer postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    @PostMapping("/comments")
    public Comment saveComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment.getUser().getAuth0id(),comment.getPost().getPostId(), comment.getContent());
    }

    @GetMapping("/commentsByUser")
    public List<Comment> getAllCommentsByUser(@RequestParam String auth0id) {
        return commentService.getAllCommentsByUserauth0id(auth0id);
    }
}