package com.epam.jmp;


import com.epam.jmp.util.Animal;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;

public class CCRunner {

    private static final Logger logger = Logger.getLogger(CCRunner.class);

    public static void main(String[] args) throws InvocationTargetException, MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException {

        Properties properties = new Properties();
        properties.setProperty("log4j.rootLogger", "TRACE,stdout,MyFile");
        properties.setProperty("log4j.rootCategory", "TRACE");

        properties.setProperty("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
        properties.setProperty("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
        properties.setProperty("log4j.appender.stdout.layout.ConversionPattern", "%d{yyyy/MM/dd HH:mm:ss.SSS} [%5p] %t (%F) - %m%n");

        properties.setProperty("log4j.appender.MyFile", "org.apache.log4j.RollingFileAppender");
        properties.setProperty("log4j.appender.MyFile.File", "my_example.log");
        properties.setProperty("log4j.appender.MyFile.MaxFileSize", "100KB");
        properties.setProperty("log4j.appender.MyFile.MaxBackupIndex", "1");
        properties.setProperty("log4j.appender.MyFile.layout", "org.apache.log4j.PatternLayout");
        properties.setProperty("log4j.appender.MyFile.layout.ConversionPattern", "%d{yyyy/MM/dd HH:mm:ss.SSS} [%5p] %t (%F) - %m%n");

        PropertyConfigurator.configure(properties);


        String clazz = "";
        logger.info("Choose animal from list below:\n1. Cat\n2. Dog\nType number of your choice:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                clazz = "Cat";
                logger.info("cat.jar");
                break;
            case "2":
                clazz = "Dog";
                logger.info("dog.jar");
                break;
            default:
                logger.info("No such case - type correct number");
        }

        try {
            logger.info("First attempt...");
            Class.forName("com.epam.jmp.util." + clazz);
        } catch (Exception ex) {
            logger.error("Failed.");
        }
        try {
            URL urls[] = {};
            JarClassLoader cl = new JarClassLoader(urls);
            cl.addFile(clazz + ".jar");
            logger.info("Second attempt...");
            cl.loadClass("com.epam.jmp.util." + clazz);
            logger.info("Success!");
        } catch (Exception ex) {
            logger.error("Failed.");
            ex.printStackTrace();
        }

        Constructor<?> cs = ClassLoader.getSystemClassLoader().loadClass("com.epam.jmp.util." + clazz).getConstructor();
        Animal instance = (Animal) cs.newInstance();
        instance.makeSound();

    }
}
