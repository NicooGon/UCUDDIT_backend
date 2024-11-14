package com.example.ucuddit.mapper;

import com.example.ucuddit.dto.RateDTO;
import com.example.ucuddit.model.Rate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RateMapper {

    RateMapper INSTANCE = Mappers.getMapper(RateMapper.class);

    @Mapping(source = "rateId", target = "rateId")
    @Mapping(source = "likes", target = "likes")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "comment", target = "comment")
    @Mapping(source = "post", target = "post")
    RateDTO rateToRateDTO(Rate rate);

    @Mapping(source = "rateId", target = "rateId")
    @Mapping(source = "likes", target = "likes")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "comment", target = "comment")
    @Mapping(source = "post", target = "post")
    Rate rateDTOToRate(RateDTO rateDTO);
}