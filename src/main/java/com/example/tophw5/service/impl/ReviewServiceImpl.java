package com.example.tophw5.service.impl;

import com.example.tophw5.dao.ReviewDao;
import com.example.tophw5.entity.Review;
import com.example.tophw5.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewDao reviewDao;

    @Autowired
    public ReviewServiceImpl(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    public Map<String, List<String>> getReviewsRestaurantById(Long id) {
        return reviewDao.getReviewsRestaurantById(id);
    }

    @Override
    public Map<String, Integer> getRatingRestaurantById(Long id) {
        return reviewDao.getRatingRestaurantById(id);
    }

    @Override
    public void addReview(Review review) {
        reviewDao.addReview(review);
    }

    @Override
    public void updateReviewById(Long restaurant_id, String review) {
        reviewDao.updateReviewById(restaurant_id, review);
    }
}
