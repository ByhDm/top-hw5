package com.example.tophw5.config;

import java.util.Properties;

public class DataBaseConnectionProperties {

    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/restaurants_db";

    public static Properties getConnectionProps() {
        Properties properties = new Properties();
        properties.setProperty("user", "homeworks");
        properties.setProperty("password", "homeworks");
        return properties;
    }
}
