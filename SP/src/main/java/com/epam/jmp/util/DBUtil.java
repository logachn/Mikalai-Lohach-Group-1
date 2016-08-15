package com.epam.jmp.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn != null) {
            return conn;
        } else {
            try {
                Properties prop = new Properties();
                prop.load(DBUtil.class.getResourceAsStream("/db.properties"));
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String pass = prop.getProperty("password");
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, pass);
            } catch (ClassNotFoundException | SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
