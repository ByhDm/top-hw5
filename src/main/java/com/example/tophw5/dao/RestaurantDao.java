package com.example.tophw5.dao;

import com.example.tophw5.entity.Restaurant;

import java.util.List;

public interface RestaurantDao {
    List<Restaurant> getAllRestaurants();
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant getRestaurantByName(String name);
    void updateDescriptionRestaurantByName(String name, String description);
    String getDescriptionRestaurantByName(String name);
    Restaurant getRestaurantById(Long id);
}
