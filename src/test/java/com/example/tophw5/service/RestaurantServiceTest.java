package com.example.tophw5.service;


import com.example.tophw5.TopHw5ApplicationTests;
import com.example.tophw5.dao.RestaurantDao;
import com.example.tophw5.entity.Restaurant;
import com.example.tophw5.exception.FoundationDateIsExpiredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Answers.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mockStatic;

class RestaurantServiceTest extends TopHw5ApplicationTests {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private RestaurantDao restaurantDao;

/*    @BeforeAll
    void addRestaurantsAndReviewsInDataBase() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Astoria");
        restaurant.setDescription("Test description 1");
        restaurantService.addRestaurant(restaurant);
        Review review = new Review();
        review.setReview("Good restaurant");
        review.setRestaurant_id(restaurantService.getAllRestaurants().get(0).getId());
        review.setRating(3);
        reviewService.addReview(review);
    }*/

//    @BeforeEach
//    void setDefaultParameters() {
//        restaurantService.addPhoneByRestaurantName("Astoria", "+79998888888");
//    }

/*
    @AfterAll
    void cleanTable() {

    }
*/

    @Test
    void getAll() {
        assertNotNull(restaurantService.getAllRestaurants());
        assertEquals("Astoria", restaurantService.getAllRestaurants().get(0).getName());
        assertEquals("+79998888888", restaurantService.getAllRestaurants().get(0).getPhoneNumber());
        assertEquals("astoria@astoria.com", restaurantService.getAllRestaurants().get(0).getEmail());
        assertEquals("Test description 1", restaurantService.getAllRestaurants().get(0).getDescription());
    }

/*
    @Test
    void addRestaurant() {
        String name = "Asia";
        String phoneNumber = "+76666666666";
        String email = "asia@asia.com";
        String description = "Test description 5";
        LocalDate date = ;
        Restaurant restaurant = new Restaurant(name, phoneNumber, email, description, date);
        restaurantService.addRestaurant(restaurant);
        assertEquals(restaurant, restaurantService.getRestaurantByName("Astoria"));
    }
*/

    @Test
    void getRestaurantByName() {
        String name = "Astoria";
        Restaurant restaurantByName = restaurantService.getRestaurantByName(name);
        assertEquals(name, restaurantByName.getName());
    }

    @Test
    void updateDescriptionRestaurantByName() {
        String newDescription = "Test description 3";
        restaurantService.updateDescriptionRestaurantByName("KFC", newDescription);
        assertEquals(newDescription, restaurantService.getDescriptionRestaurantByName("KFC"));
    }

    @Test
    void getDescriptionRestaurantByName() {
        String name = "Praga";
        String description = "Test description 2";
        String descriptionRestaurantByName = restaurantService.getDescriptionRestaurantByName(name);
        assertEquals(description, descriptionRestaurantByName);
    }

    @Test
    void getRestaurantById() {
        Long id = 3L;
        Restaurant restaurantById = restaurantService.getRestaurantById(id);
        assertEquals(id, restaurantById.getId());
    }

    @Test
    void addPhoneByRestaurantName() {
        String phone = "+79998888888";
        restaurantService.addPhoneByRestaurantName("Astoria", phone);
        assertEquals(phone, restaurantService.getRestaurantByName("Astoria").getPhoneNumber());
    }

    @Test
    void addEmailAddressByName() throws FoundationDateIsExpiredException {
        String email = "astoria@astoria.com";
        restaurantService.addEmailAddressByName("Astoria", email);
        assertEquals(email, restaurantService.getRestaurantByName("Astoria").getEmail());
    }

    @Test
    void addRestaurantByNameAndCreationDate() throws FoundationDateIsExpiredException {
        MockedStatic<LocalDate> localDateMockedStatic = mockStatic(LocalDate.class, CALLS_REAL_METHODS);
        LocalDate defaultDateNow = LocalDate.of(2012, 07, 30);
        localDateMockedStatic.when(LocalDate::now).thenReturn(defaultDateNow);

        Assertions.assertThrowsExactly(FoundationDateIsExpiredException.class,
                () -> restaurantService.addRestaurantByNameAndCreationDate("Astoria", LocalDate.of(2015, 12, 12)),
                "Restaurant with name \"" + "Astoria" + "\"" +
                        "has foundation date " + LocalDate.now().plusDays(2));

        Long test = restaurantService.addRestaurantByNameAndCreationDate("Astoria", LocalDate.of(2015, 4, 17));
        LocalDate localDateExpected = restaurantService.getCreationDateByRestaurantId(test);
        assertEquals(LocalDate.of(2015, 4, 17), localDateExpected);
    }
}
