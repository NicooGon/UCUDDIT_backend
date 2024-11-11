package com.example.ucuddit.service;

import com.example.ucuddit.model.Post;
import com.example.ucuddit.model.Rate;
import com.example.ucuddit.model.User;
import com.example.ucuddit.respository.PostRepository;
import com.example.ucuddit.respository.RateRepository;
import com.example.ucuddit.respository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RateService {

    private final RateRepository rateRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public RateService(RateRepository rateRepository, UserRepository userRepository, PostRepository postRepository) {
        this.rateRepository = rateRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public Rate toggleRate(String auth0id, Integer postId, Integer rateValue) {

        User user = userRepository.findByauth0id(auth0id);
        Post post = postRepository.findBypostId(postId);
        Rate existingRate = rateRepository.findByUser_Auth0idAndPost_PostId(auth0id, postId);

        if (existingRate != null) {
            if (existingRate.getLikes().equals(rateValue)) {
                existingRate.setLikes(0);
            } else {
                existingRate.setLikes(rateValue);
            }
            return rateRepository.save(existingRate);
        } else {
            Rate newRate = new Rate();
            newRate.setUser(user);
            newRate.setPost(post);
            newRate.setLikes(rateValue);

            return rateRepository.save(newRate);
        }
    }

    public Integer countLikesByPostId(Integer postId) {
        return rateRepository.countByPost_PostIdAndLikes(postId, 1);
    }

    public Integer countDislikesByPostId(Integer postId) {
        return rateRepository.countByPost_PostIdAndLikes(postId, -1);
    }

    public Integer getUserLikeForPost(String auth0id, Integer postId) {
        Rate rate = rateRepository.findByUser_Auth0idAndPost_PostId(auth0id, postId);
        if (rate != null) {
            return rate.getLikes();
        } else {
            return 0;
        }
    }
}
