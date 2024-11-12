package com.example.ucuddit.Mapper;

import com.example.ucuddit.DTO.PostDTO;
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
    @Mapping(source = "content", target = "content")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "createdAt", target = "createdAt")
    PostDTO postToPostDTO(Post post);

    @Mapping(source = "postId", target = "postId")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "rates", target = "rates")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "createdAt", target = "createdAt")
    Post postDTOToPost(PostDTO postDTO);
}
