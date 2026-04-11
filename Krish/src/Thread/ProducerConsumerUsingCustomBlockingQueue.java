package Krish.src.Thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerUsingCustomBlockingQueue<E> {
    private final Queue<E> queue = new LinkedList<>();
    private int maxSize = 16;

    ProducerConsumerUsingCustomBlockingQueue() {
    }

    ProducerConsumerUsingCustomBlockingQueue(int size) {
        this.maxSize = size;
    }

    // 1. put items to the queue in a synchronized and thread safe manner
    public void put(E item) throws InterruptedException {
        synchronized (this) {
            while (queue.size() == maxSize) {
                wait();
            }
            this.queue.add(item);
            notifyAll();
        }
    }

    // 2. Get items from the queue in a synchronized manner
    public E take() throws InterruptedException {
        synchronized (this) {
            while (this.queue.isEmpty()) {
                wait();
            }
            E val = this.queue.remove();
            notifyAll();
            return val;
        }
    }
}