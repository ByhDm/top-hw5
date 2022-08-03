package com.example.tophw5.mapper;

import com.example.tophw5.dto.out.RestaurantOutDTO;
import com.example.tophw5.entity.Restaurant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    RestaurantOutDTO restaurantToRestaurantOutDTO(Restaurant restaurant);
    List<RestaurantOutDTO> restaurantsToRestaurantsOutDTO(List<Restaurant> restaurants);
}
