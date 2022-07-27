package com.example.tophw5.dao;

import com.example.tophw5.config.DataBaseConnectionProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.example.tophw5.config.DataBaseConnectionProperties.DATABASE_URL;

public class ConnectionToDataBase {

    public static Connection getConnectionDB() {
        try {
            return DriverManager.getConnection(DATABASE_URL, DataBaseConnectionProperties.getConnectionProps());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
