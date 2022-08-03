package com.example.tophw5.controller;

import com.example.tophw5.entity.Review;
import com.example.tophw5.mapper.ReviewMapper;
import com.example.tophw5.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReviewMapper reviewMapper;

    @GetMapping("/{id}")
    public Map<String, List<String>> getReviewsRestaurantById(@PathVariable Long id) {
        Map<String, List<String>> reviewsRestaurantById = reviewService.getReviewsRestaurantById(id);
        return reviewMapper.reviewsToReviewsOutDTO(reviewsRestaurantById);
    }

    @GetMapping("/rating/{id}")
    Map<String, Integer> getRatingRestaurantById(@PathVariable Long id) {
        return reviewService.getRatingRestaurantById(id);
    }

    @PostMapping("/add")
    public void addReview(@RequestBody Review review) {
        reviewService.addReview(review);
    }

    @PutMapping("/update/{restaurant_id}/{review}")
    void updateReviewById(@PathVariable Long restaurant_id, @PathVariable String review) {
        reviewService.updateReviewById(restaurant_id, review);
    }
}
