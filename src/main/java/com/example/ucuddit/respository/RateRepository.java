package com.example.ucuddit.respository;

import com.example.ucuddit.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RateRepository extends JpaRepository<Rate, Integer> {
    Rate findByUser_Auth0idAndPost_PostId(String auth0id, Integer postId);
    Integer countByPost_PostIdAndLikes(Integer postId, Integer likes);
}
