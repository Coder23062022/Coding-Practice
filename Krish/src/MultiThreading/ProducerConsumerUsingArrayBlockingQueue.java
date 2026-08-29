package Krish.src.MultiThreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingArrayBlockingQueue<E> {
    static void main() {
        // Create a bounded blocking queue with a capacity of 5
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5, true);

        // Producer Thread
        Runnable producer = () -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    queue.put(i); // Blocks if queue is full
                    System.out.println("Produced: " + i);
                    Thread.sleep(100); // Simulate work
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Consumer Thread
        Runnable consumer = () -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    int value = queue.take(); // Blocks if queue is empty
                    System.out.println("Consumed: " + value);
                    Thread.sleep(150); // Simulate work
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Start threads
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}