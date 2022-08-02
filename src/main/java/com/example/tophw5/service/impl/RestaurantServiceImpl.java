package com.example.tophw5.service.impl;

import com.example.tophw5.dao.RestaurantDao;
import com.example.tophw5.entity.Restaurant;
import com.example.tophw5.exception.FoundationDateIsExpiredException;
import com.example.tophw5.exception.IncorrectEmailAddressException;
import com.example.tophw5.service.RestaurantService;
import com.example.tophw5.util.EmailUtil;
import com.example.tophw5.util.PhoneUtil;
import com.google.i18n.phonenumbers.NumberParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public Restaurant addRestaurant(Restaurant restaurant) {
        String phone = restaurant.getPhoneNumber();
        if (phone == null || phone.equals("default")) {
            restaurant.setPhoneNumber("default");
        } else {
            try {
                restaurant.setPhoneNumber(PhoneUtil.reformatRuTelephone(phone));
            } catch (NumberParseException e) {
                throw new RuntimeException(e);
            }
        }
        return restaurantDao.addRestaurant(restaurant);
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

    @Override
    public void addPhoneByRestaurantName(String name, String phone) {
        Restaurant restaurant = restaurantDao.getRestaurantByName(name);
        try {
            restaurant.setPhoneNumber(PhoneUtil.reformatRuTelephone(phone));
            restaurantDao.addRestaurant(restaurant);
        } catch (NumberParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addEmailAddressByName(String name, String emailAddress) throws FoundationDateIsExpiredException {
        Restaurant restaurant = restaurantDao.getRestaurantByName(name);
        if (EmailUtil.checkValid(emailAddress)) {
            restaurant.setEmail(emailAddress);
            restaurantDao.addRestaurant(restaurant);
        } else {
            try {
                throw new IncorrectEmailAddressException("write correct Email Address");
            } catch (IncorrectEmailAddressException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Long addRestaurantByNameAndCreationDate(String name, LocalDate creationDate) throws FoundationDateIsExpiredException {
        LocalDate dateNow = LocalDate.now();
        if (creationDate == null || dateNow.isAfter(creationDate)) {
            throw new FoundationDateIsExpiredException(name, creationDate);
        }
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setCreationDate(creationDate);
        Restaurant restaurantSave = restaurantDao.addRestaurant(restaurant);
        return restaurantSave.getId();

    }

    @Override
    public LocalDate getCreationDateByRestaurantId(Long id) {
        Restaurant restaurantById = restaurantDao.getRestaurantById(id);
        return restaurantById.getCreationDate();
    }
}
