package com.example.tophw5.entity;

import java.util.Objects;

public class Review {

    private Long id;
    private Long restaurant_id;
    private String review;
    private Integer rating;

    public Review() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review1 = (Review) o;
        return Objects.equals(id, review1.id) && Objects.equals(restaurant_id, review1.restaurant_id) && Objects.equals(review, review1.review) && Objects.equals(rating, review1.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, restaurant_id, review, rating);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", restaurant_id=" + restaurant_id +
                ", review='" + review + '\'' +
                ", rating=" + rating +
                '}';
    }
}
