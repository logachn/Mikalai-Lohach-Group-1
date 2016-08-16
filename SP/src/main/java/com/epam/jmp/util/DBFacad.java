package com.epam.jmp.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBFacad {

    public DBFacad() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        PropConfig.getProperties();
        loadDriver();
    }

    private void loadDriver() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(Config.getInstance().getDriver()).newInstance();
    }

    private Connection conn = null;

    public Connection getConnection() throws SQLException {
        if (conn != null) {
            return conn;
        } else {
            conn = DriverManager.getConnection(Config.getInstance().getUrl(), Config.getInstance().getName(), Config.getInstance().getPassword());
        }
        return conn;
    }
}
