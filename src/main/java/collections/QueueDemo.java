package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        System.out.println("queue = " + queue);
        // operations
        Integer poll = queue.poll();
        System.out.println("poll = " + poll);
        System.out.println("queue = " + queue);
        // remove from first
        queue.pollLast();
        System.out.println("after pollLast queue = " + queue);
    }
}
