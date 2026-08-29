package Krish.src.MultiThreading.AlternateThreadExecution;

//Related doc: https://www.geeksforgeeks.org/print-even-and-odd-numbers-in-increasing-order-using-two-threads-in-java/
//Time complexity: O(n)
//Space complexity: O(1)

public class OddEvenNumbers {
    static void main() {
        int n = 10;
        SequenceGenerator sequenceGenerator = new SequenceGenerator(n);

        Thread t1 = new Thread(() -> sequenceGenerator.printSequence(1), "Odd");
        Thread t2 = new Thread(() -> sequenceGenerator.printSequence(0), "Even");

        t1.start();
        t2.start();

    }

    static class SequenceGenerator {
        private final int maxLimit;
        private int counter = 1;
        private final Object lock = new Object();

        SequenceGenerator(int maxLimit) {
            this.maxLimit = maxLimit;
        }

        public void printSequence(int remainder) {
            while (true) {
                synchronized (lock) {
                    while (counter <= maxLimit && counter % 2 != remainder) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    //Break the loop once maxLimit is reached, otherwise it will go to infinite loop
                    if (counter == maxLimit) {
                        lock.notifyAll();
                        break;
                    }

                    System.out.println(Thread.currentThread().getName() + " " + counter);
                    counter++;
                    lock.notifyAll();
                }
            }
        }
    }
}