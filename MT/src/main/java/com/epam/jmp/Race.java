package com.epam.jmp;


import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race {

    Logger log = Logger.getLogger(getClass());

    private final static int CAR_QUANTITY = 10;

    private static List<String> places = new ArrayList<>();

    private int disqualifiedCar;

    public static synchronized void recordResults(String name) {
        places.add(name);
    }

    public void startRace() {
        try {

            Thread[] cars = new Thread[CAR_QUANTITY];

            for (int i = 0; i < CAR_QUANTITY; i++) {
                long friction = (long) (Math.random() * 100 + 100);
                Car car = new Car("car" + i, friction);
                cars[i] = new Thread(car);
                recordResults(car.getName());
                cars[i].start();
            }

            System.out.println(Arrays.toString(places.toArray()));

            Thread.sleep(5000);

            disqualifieCar(cars);

            for (Thread car : cars) {
                car.join();
            }

        } catch (InterruptedException e) {
            log.error(e);
        }
    }

    private void disqualifieCar(Thread[] cars) {

        disqualifiedCar = (int) (Math.random() * (CAR_QUANTITY - 1));

        if (!cars[disqualifiedCar].isInterrupted()) {
            cars[disqualifiedCar].interrupt();
        }
    }

    public void getResults() {
        log.info("Car " + disqualifiedCar + " was disqualifed");

        places.remove(disqualifiedCar);

        log.info("Places: ");

        for (int i = 0; i < places.size(); i++) {
            log.info("place " + (i + 1) + " - " + places.get(i));
        }

        log.info("Winner is " + places.get(0));
    }

}