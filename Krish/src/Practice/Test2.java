package Practice;

public class Test2 {
    public static void main(String[] args) {
        OddEvenPrint runnable1 = new OddEvenPrint(0, "Ping");
        OddEvenPrint runnable2 = new OddEvenPrint(1, "Pong");
        Thread t1 = new Thread(runnable1, "Thread1");
        Thread t2 = new Thread(runnable2, "Thread2");
        t1.start();
        t2.start();
    }
}

class OddEvenPrint implements Runnable {
    int remainder;
    static int n = 1;
    int printUpto = 10;
    static Object lock = new Object();
    String pingPong;

    OddEvenPrint(int remainder, String pingPong) {
        this.remainder = remainder;
        this.pingPong = pingPong;
    }

    @Override
    public void run() {
        while (n <= printUpto - 1) {
            synchronized (lock) {
                while (n % 2 == remainder) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + pingPong);
                n++;
                lock.notifyAll();
            }
        }
    }
}
