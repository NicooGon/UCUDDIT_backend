package com.example.ucuddit.interfaces.service;

import com.example.ucuddit.dto.PostDTO;
import com.example.ucuddit.dto.RateDTO;

import java.util.List;

public interface IRateService {

    RateDTO toggleRate(String auth0id, Integer postId, Integer rateValue);

    RateDTO toggleRateComment(String auth0id, Integer commentId, Integer rateValue);

    Integer countLikesByCommentId(Integer commentId);

    Integer countDislikesByCommentId(Integer commentId);

    Integer getUserLikeForComment(String auth0id, Integer commentId);

    Integer countLikesByPostId(Integer postId);

    Integer countDislikesByPostId(Integer postId);

    Integer getUserLikeForPost(String auth0id, Integer postId);
}
