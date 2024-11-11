package com.example.ucuddit.controller;

import com.example.ucuddit.model.Rate;
import com.example.ucuddit.service.RateService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RateController {

    private final RateService rateService;

    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @PostMapping("/toggle")
    public Rate toggleRate(@RequestParam String auth0id, @RequestParam Integer postId, @RequestParam Integer rateValue) {
        return rateService.toggleRate(auth0id, postId, rateValue);
    }

    @GetMapping("/post/{postId}/likes")
    public Integer countLikes(@PathVariable Integer postId) {
        return rateService.countLikesByPostId(postId);
    }

    @GetMapping("/post/{postId}/dislikes")
    public Integer countDislikes(@PathVariable Integer postId) {
        return rateService.countDislikesByPostId(postId);
    }

    @GetMapping("/user/{auth0id}/post/{postId}/like")
    public Integer getUserLikeForPost(@PathVariable String auth0id, @PathVariable Integer postId) {
        return rateService.getUserLikeForPost(auth0id, postId);
    }


}
