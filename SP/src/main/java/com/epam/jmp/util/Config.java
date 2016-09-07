package com.epam.jmp.util;


public final class Config {

    private String name;
    private String password;
    private String driver;
    private String url;

    private static Config instance = null;

    static synchronized Config getInstance() {
        instance = instance == null ? new Config() : instance;
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
