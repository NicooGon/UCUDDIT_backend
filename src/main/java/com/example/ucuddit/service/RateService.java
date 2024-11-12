package com.example.ucuddit.service;

import com.example.ucuddit.DTO.PostDTO;
import com.example.ucuddit.Mapper.PostMapper;
import com.example.ucuddit.model.Comment;
import com.example.ucuddit.model.Post;
import com.example.ucuddit.model.Rate;
import com.example.ucuddit.model.User;
import com.example.ucuddit.respository.CommentRepository;
import com.example.ucuddit.respository.PostRepository;
import com.example.ucuddit.respository.RateRepository;
import com.example.ucuddit.respository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService {

    private final RateRepository rateRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private static final PostMapper postMapper = PostMapper.INSTANCE;

    public RateService(RateRepository rateRepository, UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository) {
        this.rateRepository = rateRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public Rate toggleRate(String auth0id, Integer postId, Integer rateValue) {

        User user = userRepository.findByauth0id(auth0id);
        Post post = postRepository.findBypostId(postId);
        if (user == null || post == null) {
            throw new IllegalArgumentException("No user found with the specified auth0id.");
        }

        Rate existingRate = rateRepository.findByUser_Auth0idAndPost_PostId(auth0id, postId);

        if (existingRate != null) {
            if (existingRate.getLikes().equals(rateValue)) {
                existingRate.setLikes(0);
            }
            else {
                existingRate.setLikes(rateValue);
            }
            return rateRepository.save(existingRate);
        }
        else {
            Rate newRate = new Rate();
            newRate.setUser(user);
            newRate.setPost(post);
            newRate.setLikes(rateValue);

            return rateRepository.save(newRate);
        }
    }

    public Rate toggleRateComment(String auth0id, Integer commentId, Integer rateValue) {

        User user = userRepository.findByauth0id(auth0id);
        Comment comment = commentRepository.findBycommentId(commentId);
        if (user == null || comment == null) {
            throw new IllegalArgumentException("No user found with the specified auth0id.");
        }

        Rate existingRate = rateRepository.findByUser_Auth0idAndComment_commentId(auth0id, commentId);

        if (existingRate != null) {
            if (existingRate.getLikes().equals(rateValue)) {
                existingRate.setLikes(0);
            }
            else {
                existingRate.setLikes(rateValue);
            }
            return rateRepository.save(existingRate);
        }
        else {
            Rate newRate = new Rate();
            newRate.setUser(user);
            newRate.setComment(comment);
            newRate.setLikes(rateValue);

            return rateRepository.save(newRate);
        }
    }

    public Integer countLikesByCommentId(Integer commentId) {
        if (commentId == null) {
            throw new IllegalArgumentException("The commentId cannot be null or less than 1.");
        }
        return rateRepository.countByComment_CommentIdAndLikes(commentId, 1);
    }

    public Integer countDislikesByCommentId(Integer commentId) {
        if (commentId == null) {
            throw new IllegalArgumentException("The commentId cannot be null or less than 1.");
        }
        return rateRepository.countByComment_CommentIdAndLikes(commentId, -1);
    }

    public Integer getUserLikeForComment(String auth0id, Integer commentId) {
        if (commentId == null) {
            throw new IllegalArgumentException("The commentId cannot be null or less than 1.");
        }

        Rate rate = rateRepository.findByUser_Auth0idAndComment_commentId(auth0id, commentId);

        if (rate != null) {
            return rate.getLikes();
        }
        else {
            return 0;
        }
    }

    public Integer countLikesByPostId(Integer postId) {
        if (postId == null) {
            throw new IllegalArgumentException("The postId cannot be null or less than 1.");
        }
        return rateRepository.countByPost_PostIdAndLikes(postId, 1);
    }

    public Integer countDislikesByPostId(Integer postId) {
        if (postId == null) {
            throw new IllegalArgumentException("The postId cannot be null or less than 1.");
        }
        return rateRepository.countByPost_PostIdAndLikes(postId, -1);
    }

    public Integer getUserLikeForPost(String auth0id, Integer postId) {
        Rate rate = rateRepository.findByUser_Auth0idAndPost_PostId(auth0id, postId);
        if (postId == null) {
            throw new IllegalArgumentException("The postId cannot be null or less than 1.");
        }

        if (rate != null) {
            return rate.getLikes();
        }
        else {
            return 0;
        }
    }

    public List<PostDTO> getPostsByUserAndLikes(String auth0id, Integer likes) {
        if (likes == null) {
            throw new IllegalArgumentException("The likes value cannot be null.");
        }
        List<Post> posts = rateRepository.findPostsByAuth0idAndLikes(auth0id, likes);
        return posts.stream()
                .map(postMapper::postToPostDTO).toList();
    }
}
