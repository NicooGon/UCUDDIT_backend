package com.example.ucuddit.controller;

import com.example.ucuddit.dto.PostDTO;
import com.example.ucuddit.dto.RateDTO;
import com.example.ucuddit.interfaces.service.IRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RateController {

    @Autowired
    private IRateService rateService;

    @PostMapping("/toggle")
    public RateDTO toggleRate(@RequestParam String auth0id, @RequestParam Integer postId, @RequestParam Integer rateValue) {
        return rateService.toggleRate(auth0id, postId, rateValue);
    }

    @PostMapping("/toggle/comment")
    public RateDTO toggleRateComment(@RequestParam String auth0id, @RequestParam Integer commentId, @RequestParam Integer rateValue) {
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
}
