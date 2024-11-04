package com.example.ucuddit.service;

import com.example.ucuddit.model.Post;
import com.example.ucuddit.model.Rate;
import com.example.ucuddit.respository.PostRepository;
import com.example.ucuddit.respository.RateRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RateService {

    private final RateRepository rateRepository;
    private final PostRepository postRepository;

    public RateService(PostRepository postRepository, RateRepository rateRepository) {
        this.postRepository = postRepository;
        this.rateRepository = rateRepository;
    }

    public List<Rate> getAllRates() {
        return rateRepository.findAll();
    }

    public Rate saveTotalLikes(Integer postId, Integer likes) {
        Post existingPost = postRepository.findBypostId(postId);

        Rate newRate = new Rate();
        newRate.setPost(existingPost);
        newRate.setLikes(likes);
        return rateRepository.save(newRate);
    }
}
