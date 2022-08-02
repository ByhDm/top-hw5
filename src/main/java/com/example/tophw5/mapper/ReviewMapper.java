package com.example.tophw5.mapper;

import com.example.tophw5.dto.out.ReviewOutDTO;
import com.example.tophw5.entity.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewOutDTO reviewToReviewOutDTO(Review review);
}
