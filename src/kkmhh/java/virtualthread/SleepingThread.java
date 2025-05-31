package kkmhh.java.virtualthread;

import java.util.concurrent.TimeUnit;

public class SleepingThread implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println("SleepingThread interrupted: " + e.getMessage());
        }
    }
}