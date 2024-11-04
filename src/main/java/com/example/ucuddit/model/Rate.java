package com.example.ucuddit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "\"rate\"")
public class Rate {

    @Id
    @SequenceGenerator(
            name = "rate_sequence",
            sequenceName = "rate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rate_sequence"
    )

    private Integer rateId;
    private Integer likes=0;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "commentId")
    private Comment comment;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "postId")
    private Post post;

    public Rate() {
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

    @Override
    public String toString() {
        return "Rate{" +
                "rateId=" + rateId +
                ", likes=" + likes +
                ", user=" + user +
                ", comment=" + comment +
                ", post=" + post +
                '}';
    }
}
