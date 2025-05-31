package kkmhh.java.virtualthread;

public class VirtualThreadRunner {
    public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) {
            System.out.println(i);
            Thread.startVirtualThread(new SleepingThread());
//            Thread.ofVirtual().start(new SleepingThread());
        }
    }
}
