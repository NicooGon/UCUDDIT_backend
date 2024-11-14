package com.example.ucuddit.interfaces.service;

import com.example.ucuddit.dto.CommentDTO;
import com.example.ucuddit.model.Comment;

import java.util.List;

public interface ICommentService {
    List<CommentDTO> getAllCommentsByPostId(Integer postId);
    List<CommentDTO> getAllCommentsByUserauth0id(String auth0id);
    CommentDTO saveComment(String auth0id, Integer postId, String content);
}
