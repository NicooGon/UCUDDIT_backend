package com.example.ucuddit.service;

import com.example.ucuddit.DTO.CommentDTO;
import com.example.ucuddit.Mapper.CommentMapper;
import com.example.ucuddit.Mapper.CommentMapperImpl;
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
    private static final CommentMapper commentMapper = CommentMapperImpl.INSTANCE;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<CommentDTO> getAllCommentsByPostId(Integer postId) {
        List<Comment> comments = commentRepository.findByPost_PostId(postId);

        if(comments.isEmpty())
        {
            return null;
        }
        return comments.stream().map(commentMapper::commentToCommentDTO).toList();
    }

    public List<CommentDTO> getAllCommentsByUserauth0id(String auth0id) {
        List<Comment> comments = commentRepository.findByUser_auth0id(auth0id);

        if(comments.isEmpty())
        {
            return null;
        }
        return comments.stream().map(commentMapper::commentToCommentDTO).toList();
    }

    public Comment saveComment(String auth0id, Integer postId, String content) {
        Post existingPost = postRepository.findBypostId(postId);
        User existingUser = userRepository.findByauth0id(auth0id);

        if (existingPost == null || existingUser == null) {
            return null;
        }

        Comment newComment = new Comment();
        newComment.setPost(existingPost);
        newComment.setUser(existingUser);
        newComment.setContent(content);
        newComment.setCreationDate(LocalDate.now());

        return commentRepository.save(newComment);
    }
}
