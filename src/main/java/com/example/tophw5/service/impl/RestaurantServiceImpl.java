package com.example.tophw5.service.impl;

import com.example.tophw5.dao.RestaurantDao;
import com.example.tophw5.entity.Restaurant;
import com.example.tophw5.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantDao restaurantDao;

    @Autowired
    public RestaurantServiceImpl(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantDao.getAllRestaurants();
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantDao.addRestaurant(restaurant);
    }

    @Override
    public Restaurant getRestaurantByName(String name) {
        return restaurantDao.getRestaurantByName(name);
    }

    @Override
    public void updateDescriptionRestaurantByName(String name, String description) {
        restaurantDao.updateDescriptionRestaurantByName(name, description);
    }

    @Override
    public String getDescriptionRestaurantByName(String name) {
        return restaurantDao.getDescriptionRestaurantByName(name);
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantDao.getRestaurantById(id);
    }
}
