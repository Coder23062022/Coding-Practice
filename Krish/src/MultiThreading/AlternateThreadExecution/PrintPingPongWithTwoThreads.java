package Krish.src.MultiThreading.AlternateThreadExecution;

//Same problem as OddEvenNumbers

public class PrintPingPongWithTwoThreads {
    public static void main(String[] args) {
        int n = 10;
        PrintPingPong printPingPong = new PrintPingPong(n);

        Thread t1 = new Thread(() -> printPingPong.printSequence(1, "Ping"), "T1");
        Thread t2 = new Thread(() -> printPingPong.printSequence(0, "Pong"), "T2");

        t1.start();
        t2.start();
    }

    static class PrintPingPong {
        int maxLimit;
        private int counter = 1;
        private final Object lock = new Object();

        PrintPingPong(int maxLimit) {
            this.maxLimit = maxLimit;
        }

        public void printSequence(int remainder, String pingPong) {
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
                    if (counter > maxLimit) {
                        lock.notifyAll();
                        break;
                    }

                    System.out.println(Thread.currentThread().getName() + " " + pingPong);
                    counter++;
                    lock.notifyAll();
                }
            }
        }
    }
}