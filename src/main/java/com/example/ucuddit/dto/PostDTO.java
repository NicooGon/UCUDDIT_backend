package com.example.ucuddit.dto;

import com.example.ucuddit.model.Rate;
import com.example.ucuddit.model.User;

import java.time.LocalDate;
import java.util.List;

public class PostDTO {

    private Integer postId;
    private User user;
    private List<Rate> rates;
    private String title;
    private Integer community;
    private String content;
    private String image;
    private LocalDate createdAt;

    public PostDTO() {
    }

    public PostDTO(Integer postId, User user, List<Rate> rates, String title, String content, String image, LocalDate createdAt) {
        this.postId = postId;
        this.user = user;
        this.rates = rates;
        this.title = title;
        this.content = content;
        this.image = image;
        this.createdAt = createdAt;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCommunity() {
        return community;
    }

    public void setCommunity(Integer community) {
        this.community = community;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}