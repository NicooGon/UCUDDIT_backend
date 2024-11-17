package com.example.ucuddit.interfaces.service;

import com.example.ucuddit.dto.PostDTO;

import java.util.List;

public interface IPostService {
    PostDTO getPostById(Integer postId);

    List<PostDTO> getAllPosts();

    List<PostDTO> getAllPostByUserauth0id(String auth0id);

    List<PostDTO> getPostByTitle(String title);

    PostDTO createPost(String auth0id, String title, String content);
}
