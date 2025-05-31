package kkmhh.java.virtualthread;

public class PlateformThreadRunner {
    public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) {
            System.out.println(i);
            new Thread(new SleepingThread()).start();
        }
    }
}
