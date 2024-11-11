package com.example.ucuddit.respository;

import com.example.ucuddit.model.Post;
import com.example.ucuddit.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RateRepository extends JpaRepository<Rate, Integer> {
    Rate findByUser_Auth0idAndPost_PostId(String auth0id, Integer postId);
    Integer countByPost_PostIdAndLikes(Integer postId, Integer likes);
    Rate findByUser_Auth0idAndComment_commentId(String auth0id, Integer commentId);
    Integer countByComment_CommentIdAndLikes(Integer commentId, Integer likes);
    @Query("SELECT p FROM Post p JOIN Rate r ON p.postId = r.post.postId " +
            "WHERE r.user.auth0id = :auth0id AND r.likes = :likes")
    List<Post> findPostsByAuth0idAndLikes(String auth0id, Integer likes);
}
