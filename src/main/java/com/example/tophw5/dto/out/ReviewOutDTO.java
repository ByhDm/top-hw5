package com.example.tophw5.dto.out;

import com.example.tophw5.entity.Restaurant;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewOutDTO {
    private Long id;
    private Long restaurant_id;
    private String review;
    private double rating;

}
