package com.example.ucuddit.controller;

import com.example.ucuddit.dto.CommentDTO;
import com.example.ucuddit.interfaces.service.ICommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CommentController {

    private final ICommentService commentService;

    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/commentsByPost")
    public List<CommentDTO> getAllCommentsByPost(@RequestParam Integer postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    @PostMapping("/comments")
    public CommentDTO saveComment(@RequestBody CommentDTO comment) {
        return commentService.saveComment(comment.getUser().getAuth0id(),comment.getPost().getPostId(), comment.getContent());
    }

    @GetMapping("/commentsByUser")
    public List<CommentDTO> getAllCommentsByUser(@RequestParam String auth0id) {
        return commentService.getAllCommentsByUserauth0id(auth0id);
    }
}