package multithreading;

import java.sql.Time;
import java.util.ConcurrentModificationException;
import java.util.concurrent.*;

public class MultiThreadDemo {

    static void testMethod() {
        System.out.println("testMethod()");
    }

    public static void main(String[] args) throws InterruptedException {
//        threadDemo();
        executorDemo();
    }

    /**
     * Problems with Thread - fine for small scale applications,
     * - thread creation and tear down is an expensive operation
     * - high resource consumption
     * - that we have no limitation on the thread
     * <p>
     * Executor framework which utilizes the thread from ThreadPool we can re-use threads from thread pool.
     * utilizes work-queue - tasks (task in turn uses Thread)
     * ThreadPool can have only limited number of threads.
     */
    private static void executorDemo() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors = " + availableProcessors);

        // create a Thread pool of size 2
        ExecutorService executor = Executors.newFixedThreadPool(2);
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
            executor.submit(t3);
        }
        System.out.println("Shutting down the executor service");


        // to receive the result from a Thread we can use Callable Interface
        // unlike Runnable interface they can return and value
        try {
            Future<Integer> future = executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                    return 5;
                }
            });
//        while (!future.isDone()) {
//                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
//        }
            Integer integer;
            integer = future.get();
//            integer = future.get(25, TimeUnit.SECONDS);
            System.out.println("integer received from callable = " + integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // Shutdown the service
        executor.shutdown(); // wait for the threads to complete
        try { // did not shut down the executor even after timeout
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void threadDemo() throws InterruptedException {
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
