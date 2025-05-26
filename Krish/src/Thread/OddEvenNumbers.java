package Krish.src.Thread;

//Related doc: https://www.geeksforgeeks.org/print-even-and-odd-numbers-in-increasing-order-using-two-threads-in-java/

public class OddEvenNumbers {
    volatile static int counter = 1;
    int limit;

    OddEvenNumbers(int limit) {
        this.limit = limit;
    }

    //Function to print odd numbers
    public synchronized void printOddNum() {
        while (counter <= limit) {
            if (counter % 2 == 1) { //counter is odd, print it
                System.out.println(Thread.currentThread().getName() + ": " + counter);
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Function to print even numbers
    public synchronized void printEvenNum() {
        while (counter <= limit) {
            if (counter % 2 == 0) { //counter is even, print it
                System.out.println(Thread.currentThread().getName() + ": " + counter);
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        OddEvenNumbers printer = new OddEvenNumbers(10);
        Thread t1 = new Thread(printer::printOddNum);
        t1.setName("Odd");
        Thread t2 = new Thread(printer::printEvenNum);
        t2.setName("Even");
        t1.start();
        t2.start();
    }
}