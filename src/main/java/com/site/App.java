package com.site;
import java.sql.*;


public class App
{
    private static final String URL = "jdbc:mysql://localhost:3306/myapp?serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "Yonas@1996";

    public static void main( String[] args )
    {

        System.out.println("Connecting to database...");
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("Database connected successfully!");

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
        }
    }
}
