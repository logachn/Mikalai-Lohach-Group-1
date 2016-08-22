package com.epam.jmp;


import org.apache.log4j.Logger;

public class Car implements Runnable {

    private static final long MAX_DISTANCE = 1000;

    Logger log = Logger.getLogger(getClass());

    private long friction;
    private long distance;

    private String name;

    public Car(String name, long friction) {
        this.name = name;
        this.friction = friction;
    }

    public String getName() {
        return name;
    }

    public void run() {
        try {
            while (distance < MAX_DISTANCE) {
                Thread.sleep(friction);
                distance += 100;
                log.info(name + " " + distance);
            }
        } catch (InterruptedException e) {
            log.error(e);
        }
    }
}
