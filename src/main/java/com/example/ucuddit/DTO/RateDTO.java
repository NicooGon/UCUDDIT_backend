package com.example.ucuddit.DTO;

import com.example.ucuddit.model.Comment;
import com.example.ucuddit.model.Post;
import com.example.ucuddit.model.User;

public class RateDTO {

    private Integer rateId;
    private Integer likes;
    private User user;
    private Comment comment;
    private Post post;

    public RateDTO() {
    }

    public RateDTO(Integer rateId, Integer likes, User user, Comment comment, Post post) {
        this.rateId = rateId;
        this.likes = likes;
        this.user = user;
        this.comment = comment;
        this.post = post;
    }

    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
