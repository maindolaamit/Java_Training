package multithreading;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Race condition happening
 */
public class RaceConditionDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);

        // Assigned account to thread - two persons withdrawing money at the same time
        Thread t1 = new Thread(account);
        Thread t2 = new Thread(account);
        t1.setName("Tushar");
        t2.setName("Patil");

        t1.start();
        t2.start();
    }
}

class BankAccount implements Runnable {
    private int balance;

    public BankAccount(int i) {
        this.balance = i;
    }

    public void showBalance() {
        System.out.println("Current Balance : " + this.balance);
    }

    public void withdraw(int withdrawAmount) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("%s is withdrawing money.", threadName));
        if (this.balance >= withdrawAmount) {
            // sleep for some random time to invoke a race condition
            int sleepTime = ThreadLocalRandom.current().nextInt(1, 10);
            System.out.println(String.format("%s is sleeping for %d", threadName, sleepTime));
            Thread.sleep(TimeUnit.SECONDS.toMillis(sleepTime));
            // Thread will try to withdraw balance after waking up
            this.balance -= withdrawAmount;
            System.out.println(String.format("%s - Deducted ", threadName, withdrawAmount));
            showBalance();
        } else {
            System.out.println(this.balance + " : Insufficient Balance for withdrawal.");
        }
    }

    @Override
    public void run() {
        try {
            withdraw(80);
            if (balance < 0) {
                System.out.println("Money overdrawn!!!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}