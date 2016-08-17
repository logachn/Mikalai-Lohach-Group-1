package com.epam.jmp.util;


import java.io.IOException;
import java.util.Properties;

public class PropConfig {

    private final static String FILE = "/db.properties";
    private final static String DRIVER = "driver";
    private final static String URL = "url";
    private final static String NAME = "name";
    private final static String PASS = "password";

    public static void getProperties() throws IOException {
        Config config = Config.getInstance();
        Properties prop = new Properties();
        prop.load(DBFacad.class.getResourceAsStream(FILE));
        config.setDriver(prop.getProperty(DRIVER));
        config.setUrl(prop.getProperty(URL));
        config.setName(prop.getProperty(NAME));
        config.setPassword(prop.getProperty(PASS));
    }

}
