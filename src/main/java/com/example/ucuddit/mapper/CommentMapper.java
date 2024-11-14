package com.example.ucuddit.mapper;

import com.example.ucuddit.dto.CommentDTO;
import com.example.ucuddit.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(source = "commentId", target = "commentId")
    @Mapping(source = "post", target = "post")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "creationDate", target = "creationDate")
    CommentDTO commentToCommentDTO(Comment comment);

    @Mapping(source = "commentId", target = "commentId")
    @Mapping(source = "post", target = "post")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "creationDate", target = "creationDate")
    Comment commentDTOToComment(CommentDTO commentDTO);
}