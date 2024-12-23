package com.example.ucuddit.mapper;

import com.example.ucuddit.dto.PostDTO;
import com.example.ucuddit.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(source = "postId", target = "postId")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "rates", target = "rates")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "community", target = "community")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "createdAt", target = "createdAt")
    PostDTO postToPostDTO(Post post);

    @Mapping(source = "postId", target = "postId")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "rates", target = "rates")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "community", target = "community")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "createdAt", target = "createdAt")
    Post postDTOToPost(PostDTO postDTO);
}