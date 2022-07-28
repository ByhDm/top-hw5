package com.example.tophw5.dao;

import com.example.tophw5.config.DataBaseConnectionProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.example.tophw5.config.DataBaseConnectionProperties.DATABASE_URL;

public class ConnectionToDataBase {

    private static final Logger logger = LoggerFactory.getLogger(ConnectionToDataBase.class);

    public static Connection getConnectionDB() {
        try {
            return DriverManager.getConnection(DATABASE_URL, DataBaseConnectionProperties.getConnectionProps());
        } catch (SQLException e) {
            logger.error("Incorrect dataBaseURL '{}' or connection properties '{}'"
                    , DATABASE_URL
                    , DataBaseConnectionProperties.getConnectionProps()
                    , e);
            throw new RuntimeException();
        }
    }
}
