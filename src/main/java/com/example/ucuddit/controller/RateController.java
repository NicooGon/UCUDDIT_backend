package com.example.ucuddit.controller;

import com.example.ucuddit.model.Post;
import com.example.ucuddit.model.Rate;
import com.example.ucuddit.service.RateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/toggle/comment")
    public Rate toggleRateComment(@RequestParam String auth0id, @RequestParam Integer commentId, @RequestParam Integer rateValue) {
        return rateService.toggleRateComment(auth0id, commentId, rateValue);
    }

    @GetMapping("/post/{postId}/likes")
    public Integer countLikes(@PathVariable Integer postId) {
        return rateService.countLikesByPostId(postId);
    }

    @GetMapping("/post/{postId}/dislikes")
    public Integer countDislikes(@PathVariable Integer postId) {
        return rateService.countDislikesByPostId(postId);
    }

    @GetMapping("/comment/{commentId}/likes")
    public Integer countLikesByComment(@PathVariable Integer commentId) {
        return rateService.countLikesByCommentId(commentId);
    }

    @GetMapping("/comment/{commentId}/dislikes")
    public Integer countDislikesByComment(@PathVariable Integer commentId) {
        return rateService.countDislikesByCommentId(commentId);
    }

    @GetMapping("/user/{auth0id}/post/{postId}/like")
    public Integer getUserLikeForPost(@PathVariable String auth0id, @PathVariable Integer postId) {
        return rateService.getUserLikeForPost(auth0id, postId);
    }

    @GetMapping("/user/{auth0id}/comment/{commentId}/like")
    public Integer getUserLikeForComment(@PathVariable String auth0id, @PathVariable Integer commentId) {
        return rateService.getUserLikeForComment(auth0id, commentId);
    }

    @GetMapping("/likedByUser")
    public List<Post> getLikedPosts(@RequestParam String auth0id, Integer likes) {
        return rateService.getPostsByUserAndLikes(auth0id, likes);
    }
}
