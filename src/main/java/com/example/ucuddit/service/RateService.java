package com.example.ucuddit.service;

import com.example.ucuddit.dto.PostDTO;
import com.example.ucuddit.dto.RateDTO;
import com.example.ucuddit.interfaces.service.IRateService;
import com.example.ucuddit.mapper.PostMapper;
import com.example.ucuddit.model.Comment;
import com.example.ucuddit.model.Post;
import com.example.ucuddit.model.Rate;
import com.example.ucuddit.model.User;
import com.example.ucuddit.respository.CommentRepository;
import com.example.ucuddit.respository.PostRepository;
import com.example.ucuddit.respository.RateRepository;
import com.example.ucuddit.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService implements IRateService {

    @Autowired
    private RateRepository rateRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    private static final PostMapper postMapper = PostMapper.INSTANCE;

    public RateDTO toggleRate(String auth0id, Integer postId, Integer rateValue) {

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
            existingRate = rateRepository.save(existingRate);
            return new RateDTO(existingRate.getRateId(), existingRate.getLikes(), user, null, post);
        }
        else {
            Rate newRate = new Rate();
            newRate.setUser(user);
            newRate.setPost(post);
            newRate.setLikes(rateValue);

            Rate savedRate = rateRepository.save(newRate);
            return new RateDTO(savedRate.getRateId(), savedRate.getLikes(), user, null, post);
        }
    }

    public RateDTO toggleRateComment(String auth0id, Integer commentId, Integer rateValue) {

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
            existingRate = rateRepository.save(existingRate);
            return new RateDTO(existingRate.getRateId(), existingRate.getLikes(), user, comment, null);
        }
        else {
            Rate newRate = new Rate();
            newRate.setUser(user);
            newRate.setComment(comment);
            newRate.setLikes(rateValue);

            Rate savedRate = rateRepository.save(newRate);
            return new RateDTO(savedRate.getRateId(), savedRate.getLikes(), user, comment, null);
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
