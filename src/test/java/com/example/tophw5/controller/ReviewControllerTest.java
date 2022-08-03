package com.example.tophw5.controller;

import com.example.tophw5.dto.out.ReviewOutDTO;
import com.example.tophw5.service.RestaurantService;
import com.example.tophw5.service.RestaurantServiceTest;
import com.example.tophw5.service.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class ReviewControllerTest extends RestaurantServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    protected RestaurantService restaurantService;

    @Test
    void getReviewsRestaurantById() throws Exception {
        ObjectMapper objectMapper = new JsonMapper();
        String expected = objectMapper.writeValueAsString(reviewService.getReviewsRestaurantById(1L));
        this.mockMvc.perform(get("/review/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void getRatingRestaurantById() throws Exception {
        Map<String, Integer> ratingRestaurantById = reviewService.getRatingRestaurantById(1L);
        this.mockMvc.perform(get("/review/rating/{id}", 1L))
                .andDo(print())
                .andExpect(content().json(String.valueOf(ratingRestaurantById)));
    }

    @Test
    void addReview() throws Exception {
        ReviewOutDTO review = ReviewOutDTO.builder().review("Test review 3")
                .restaurant_id(restaurantService.getRestaurantByName("Donald Duck").getId())
                .rating(1)
                .build();
        ObjectMapper objectMapper = new JsonMapper();
        String obj = objectMapper.writeValueAsString(review);
        this.mockMvc.perform(post("/review/add")
                        .contentType(MediaType.APPLICATION_JSON).content(obj))
                .andExpect(status().isOk());
    }
}
