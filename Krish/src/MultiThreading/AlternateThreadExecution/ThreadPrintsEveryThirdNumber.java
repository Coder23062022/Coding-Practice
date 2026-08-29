package Krish.src.MultiThreading.AlternateThreadExecution;

//Same problem as OddEvenNumbers, with 3 threads

public class ThreadPrintsEveryThirdNumber {
    static void main() {
        int n = 10;
        SequenceGenerator sequenceGenerator = new SequenceGenerator(n);

        Thread t1 = new Thread(() -> sequenceGenerator.printSequence(1), "T1");
        Thread t2 = new Thread(() -> sequenceGenerator.printSequence(2), "T2");
        Thread t3 = new Thread(() -> sequenceGenerator.printSequence(0), "T3");

        t1.start();
        t2.start();
        t3.start();
    }

    static class SequenceGenerator {
        private final int maxLimit;
        private int counter = 1;
        private final Object lock = new Object();

        SequenceGenerator(int maxLimit) {
            this.maxLimit = maxLimit;
        }

        // If number%3==1 then T1 will print the number and increment it else will go in
        // the wait state.
        // If number%3==2 then T2 will print the number and increment it else will go in
        // the wait state.
        // If number%3==0 then T3 will print the number and increment it else will go in
        // the wait state.

        public void printSequence(int remainder) {
            while (true) {
                synchronized (lock) {
                    while (counter <= maxLimit && counter % 3 != remainder) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    //Break the loop once maxLimit is reached, otherwise it will go to infinite loop
                    if (counter > maxLimit) {
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