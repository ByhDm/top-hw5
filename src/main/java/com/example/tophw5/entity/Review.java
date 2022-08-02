package com.example.tophw5.entity;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Review {

    private Long id;
    private Long restaurant_id;
    private String review;
    private Integer rating;

}
