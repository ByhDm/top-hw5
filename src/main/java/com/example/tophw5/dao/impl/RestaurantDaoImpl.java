package com.example.tophw5.dao.impl;

import com.example.tophw5.dao.ConnectionToDataBase;
import com.example.tophw5.dao.RestaurantDao;
import com.example.tophw5.entity.Restaurant;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantDaoImpl implements RestaurantDao {

    @Override
    public List<Restaurant> getAllRestaurants() {
        String getQuery = "SELECT * FROM restaurants";
        List<Restaurant> restaurants = new ArrayList<>();
        try (PreparedStatement preparedStatement = ConnectionToDataBase.getConnectionDB().prepareStatement(getQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(resultSet.getLong("id"));
                restaurant.setName(resultSet.getString(2));
                restaurant.setPhoneNumber(resultSet.getString(3));
                restaurant.setEmail(resultSet.getString(4));
                restaurant.setDescription(resultSet.getString(5));
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        String getQuery = "INSERT INTO restaurants (name, phoneNumber, email, description) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = ConnectionToDataBase.getConnectionDB().prepareStatement(getQuery)) {
            preparedStatement.setString(1, restaurant.getName());
            preparedStatement.setString(2, restaurant.getPhoneNumber());
            preparedStatement.setString(3, restaurant.getEmail());
            preparedStatement.setString(4, restaurant.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Restaurant getRestaurantByName(String name) {
        String getQuery = "SELECT * FROM restaurants WHERE name = ?";
        Restaurant restaurant = new Restaurant();
        try (PreparedStatement preparedStatement = ConnectionToDataBase.getConnectionDB().prepareStatement(getQuery)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                restaurant.setId(resultSet.getLong("id"));
                restaurant.setName(resultSet.getString(2));
                restaurant.setPhoneNumber(resultSet.getString(3));
                restaurant.setEmail(resultSet.getString(4));
                restaurant.setDescription(resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public void updateDescriptionRestaurantByName(String name, String description) {
        String getQuery = "UPDATE restaurants SET description = ? WHERE name = ?";
        try (PreparedStatement preparedStatement = ConnectionToDataBase.getConnectionDB().prepareStatement(getQuery)) {
            preparedStatement.setString(1, description);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getDescriptionRestaurantByName(String name) {
        String getQuery = "SELECT description FROM restaurants WHERE name = ?";
        try (PreparedStatement preparedStatement = ConnectionToDataBase.getConnectionDB().prepareStatement(getQuery)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getString("description");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        String getQuery = "SELECT * FROM restaurants WHERE id = ?";
        Restaurant restaurant = new Restaurant();
        try (PreparedStatement preparedStatement = ConnectionToDataBase.getConnectionDB().prepareStatement(getQuery)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                restaurant.setId(resultSet.getLong(1));
                restaurant.setName(resultSet.getString(2));
                restaurant.setPhoneNumber(resultSet.getString(3));
                restaurant.setEmail(resultSet.getString(4));
                restaurant.setDescription(resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }
}