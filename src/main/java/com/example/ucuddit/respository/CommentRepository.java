package com.example.ucuddit.respository;
import com.example.ucuddit.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPost_PostId(Integer postId);
    List<Comment> findByUser_auth0id(String auth0id);
    Comment findBycommentId(Integer commentId);
}
