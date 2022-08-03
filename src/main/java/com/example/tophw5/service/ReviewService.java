package com.example.tophw5.service;

import com.example.tophw5.entity.Review;

import java.util.List;
import java.util.Map;

public interface ReviewService {
    Map<String, List<String>> getReviewsRestaurantById(Long id);
    Map<String, Integer> getRatingRestaurantById(Long id);
    void addReview(Review review);
    void updateReviewById(Long restaurant_id, String review);
}
