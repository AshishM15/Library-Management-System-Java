package com.ashishit;

import java.sql.*;

public class DBConnect {

    private static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/librarydb",
                    "root",
                    "Ashish2001@"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
