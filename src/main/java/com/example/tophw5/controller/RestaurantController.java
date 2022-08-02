package com.example.tophw5.controller;

import com.example.tophw5.dto.out.RestaurantOutDTO;
import com.example.tophw5.entity.Restaurant;
import com.example.tophw5.mapper.RestaurantMapper;
import com.example.tophw5.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantMapper restaurantMapper;

    @GetMapping("/all")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @PostMapping("/add")
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
    }

    @GetMapping("/name/{name}")
    public RestaurantOutDTO getRestaurantByName(@PathVariable String name) {
        Restaurant restaurant = restaurantService.getRestaurantByName(name);
        return restaurantMapper.restaurantToRestaurantOutDTO(restaurant);
    }

    @PutMapping("/update/{name}/{description}")
    public void updateDescriptionRestaurantByName(@PathVariable String name, @PathVariable String description) {
        restaurantService.updateDescriptionRestaurantByName(name, description);
    }

    @GetMapping("/description/{name}")
    public String getDescriptionRestaurantByName(@PathVariable String name) {
        return restaurantService.getDescriptionRestaurantByName(name);
    }

    @GetMapping("/id/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }
}
