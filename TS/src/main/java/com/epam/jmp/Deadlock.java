package com.epam.jmp;

import org.apache.log4j.Logger;

public class Deadlock {

    private static final Logger log = Logger.getLogger(Deadlock.class);

    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    private static Thread t11;
    private static Thread t12;
    private static Thread t13;
    private static Thread t14;
    private static Thread t21;
    private static Thread t22;
    private static Thread t23;
    private static Thread t24;

    public static void main(String[] args) throws InterruptedException {

        initThreads();

        t11.start();
        t21.start();
        t12.start();
        t22.start();
        t13.start();
        t23.start();
        t14.start();
        t24.start();

    }

    private static void initThreads() {

        //t11 lock resource 1 and wait resource 2
        t11 = new Thread() {
            public void run() {

                synchronized (resource1) {
                    log.info(t11.getName() + " 11: locked resource 1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }

                    log.info(t11.getName() + " 11: waiting for release of resource 2");

                    synchronized (resource2) {
                        log.info(t11.getName() + " 11: locked resource 2");
                    }
                }
            }
        };

        //t21 lock resource 2 and wait resource 1
        t21 = new Thread() {
            public void run() {

                synchronized (resource2) {
                    log.info(t21.getName() + " 21: locked resource 2");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }

                    log.info(t21.getName() + " 21: waiting for release of resource 1");

                    synchronized (resource1) {
                        log.info(t21.getName() + " 21: locked resource 1");
                    }
                }
            }
        };

        t12 = new Thread() {
            public void run() {

                log.info(t12.getName() + " 12: waiting for release of resource 1");

                synchronized (resource1) {
                    log.info(t12.getName() + " 12: locked resource 1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        t22 = new Thread() {
            public void run() {

                log.info(t22.getName() + " 22: waiting for release of resource 2");

                synchronized (resource1) {
                    log.info(t22.getName() + " 22: locked resource 2");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        t13 = new Thread() {
            public void run() {

                log.info(t13.getName() + " 13: waiting for release of resource 1");

                synchronized (resource1) {
                    log.info("Thread 13: locked resource 1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        t23 = new Thread() {
            public void run() {

                log.info(t23.getName() + " 23: waiting for release of resource 2");

                synchronized (resource1) {
                    log.info(t23.getName() + " 23: locked resource 2");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        t14 = new Thread() {
            public void run() {

                log.info(t14.getName() + " 14: waiting for release of resource 1");

                synchronized (resource1) {
                    log.info(t14.getName() + " 14: locked resource 1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        t24 = new Thread() {
            public void run() {

                log.info(t24.getName() + " 24: waiting for release of resource 2");

                synchronized (resource1) {
                    log.info(t24.getName() + " 24: locked resource 2");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

    }
}