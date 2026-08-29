package Krish.src.MultiThreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingReentrantLock {
    static class BoundedBuffer {
        private final Queue<Integer> queue = new LinkedList<>();
        private final int capacity;

        // Locks and Conditions for fine-grained synchronization
        private final Lock lock = new ReentrantLock(true);
        private final Condition notFull = lock.newCondition();
        private final Condition notEmpty = lock.newCondition();

        public BoundedBuffer(int capacity) {
            this.capacity = capacity;
        }

        public void produce(int value) throws InterruptedException {
            lock.lock();
            try {
                // 1. Wait if the buffer is full
                while (queue.size() == capacity) {
                    System.out.println("[Buffer FULL] Producer is waiting...");
                    notFull.await();
                }

                // 2. Add item to buffer
                queue.add(value);
                System.out.println("🏭 Produced: " + value + " | Buffer Size: " + queue.size());

                // 3. Signal waiting consumers that data is available
                notEmpty.signalAll();
            } finally {
                lock.unlock(); // Ensure lock is always released
            }
        }

        public int consume() throws InterruptedException {
            lock.lock();
            try {
                // 1. Wait if the buffer is empty
                while (queue.isEmpty()) {
                    System.out.println("[Buffer EMPTY] Consumer is waiting...");
                    notEmpty.await();
                }

                // 2. Remove item from buffer
                int value = queue.poll();
                System.out.println("🍽️ Consumed: " + value + " | Buffer Size: " + queue.size());

                // 3. Signal waiting producers that space is available
                notFull.signalAll();
                return value;
            } finally {
                lock.unlock();
            }
        }
    }

    static void main() {
        BoundedBuffer sharedBuffer = new BoundedBuffer(5); // Buffer capacity of 5
        Random random = new Random();

        // Producer Thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    sharedBuffer.produce(i);
                    Thread.sleep(random.nextInt(300)); // Simulate production delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    sharedBuffer.consume();
                    Thread.sleep(random.nextInt(600)); // Simulate consumption delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}