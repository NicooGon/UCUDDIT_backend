package com.example.ucuddit.DTO;

import com.example.ucuddit.model.Post;
import com.example.ucuddit.model.User;

import java.time.LocalDate;

public class CommentDTO {

    private Integer commentId;
    private Post post;
    private User user;
    private String content;
    private LocalDate creationDate;

    public CommentDTO() {
    }

    public CommentDTO(Integer commentId, Post post, User user, String content, LocalDate creationDate) {
        this.commentId = commentId;
        this.post = post;
        this.user = user;
        this.content = content;
        this.creationDate = creationDate;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
