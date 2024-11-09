package com.example.ucuddit.service;

import com.example.ucuddit.model.Comment;
import com.example.ucuddit.model.Post;
import com.example.ucuddit.model.User;
import com.example.ucuddit.respository.CommentRepository;
import com.example.ucuddit.respository.PostRepository;
import com.example.ucuddit.respository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Comment> getAllCommentsByPostId(Integer postId) {
        return commentRepository.findByPost_PostId(postId);
    }

    public List<Comment> getAllCommentsByUserauth0id(String auth0id) {
        return commentRepository.findByUser_auth0id(auth0id);
    }

    public Comment saveComment(String auth0id, Integer postId, String content) {
        Post existingPost = postRepository.findBypostId(postId);
        User existingUser = userRepository.findByauth0id(auth0id);

        Comment newComment = new Comment();
        newComment.setPost(existingPost);
        newComment.setUser(existingUser);
        newComment.setContent(content);
        newComment.setCreationDate(LocalDate.now());

        return commentRepository.save(newComment);
    }
}
