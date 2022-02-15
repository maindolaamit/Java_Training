package multithreading;

import java.sql.Time;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MultiThreadDemo {

    static void testMethod() {
        System.out.println("testMethod()");
    }

    public static void main(String[] args) throws InterruptedException {
        // Create a thread view its state
        Thread t1 = new MyThread();
        t1.setName("Thread 1");
        System.out.println(String.format("Starting %s - %s", t1.getName(), t1.getState()));
        t1.start(); // Have to ivoke it to start a thread
        System.out.println(String.format("Thread State  %s", t1.getState()));

        // Create another thread using Runnable interface
        Thread t2 = new Thread(() -> System.out.println("Thread using Runnable = " + t1.getState()));
        t2.setName("Thread 2");
        t2.start();

        // We can launch multiple threads
        System.out.println();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread t3 =
                    new Thread(() -> { // Anonymous class of Runnable interface
                        try {
                            System.out.println(String.format("Thread %s - %s", Thread.currentThread().getName(),
                                    Thread.currentThread().getState()));
                            int sleepTime = ThreadLocalRandom.current().nextInt(1, 5);
                            Thread.sleep(TimeUnit.SECONDS.toMillis(sleepTime));
                            System.out.println(String.format("Thread %s - Completed",
                                    Thread.currentThread().getName()));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
            t3.setName("Thread " + finalI);
            t3.start();
        }
        // We can not re-use a Thread once it is terminated
        Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        t2.start(); // Will throw IllegalThreadStateException
        System.out.println(String.format("Thread State  %s", t1.getState()));
    }
}
