package com.example.ucuddit.respository;

import com.example.ucuddit.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findBypostId(Integer postId);
    List<Post> findByUser_auth0id(String auth0id);
    List<Post> findByTitleContainingIgnoreCase(String title);
}