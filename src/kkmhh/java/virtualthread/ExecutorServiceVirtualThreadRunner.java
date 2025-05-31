package kkmhh.java.virtualthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceVirtualThreadRunner {
    public static void main(String[] args) {

        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < 1_000_000; i++) {
                System.out.println(i);
                executorService.execute(new SleepingThread());
            }
        }
    }
}
