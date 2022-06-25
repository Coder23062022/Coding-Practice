package src.Thread;

public class OddAndEvenNumbers {
	public static void main(String[] args) {
		OddAndEvenNumbersGeneration runnable1 = new OddAndEvenNumbersGeneration(1);
		OddAndEvenNumbersGeneration runnable2 = new OddAndEvenNumbersGeneration(0);

		Thread t1 = new Thread(runnable1, "Thread1");
		Thread t2 = new Thread(runnable2, "Thread2");

		t1.start();
		t2.start();
	}
}

class OddAndEvenNumbersGeneration implements Runnable {
	static int number = 1;
	int remainder;
	int PRINT_NUMBERS_UPTO = 10;
	static Object lock = new Object();

	OddAndEvenNumbersGeneration(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public void run() {
		while (number <= PRINT_NUMBERS_UPTO - 1) {
			synchronized (lock) {
				while (number % 2 != remainder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notifyAll();
			}
		}
	}
}