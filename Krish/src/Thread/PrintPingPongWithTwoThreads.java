package Thread;

public class PrintPingPongWithTwoThreads {
	public static void main(String[] args) {
		new Thread(new PrintPingPong(1, "Ping"), "T1").start();
		new Thread(new PrintPingPong(0, "Pong"), "T2").start();
	}
}

class PrintPingPong implements Runnable {
	int noOfTimesToBePrinted = 10;
	static int number = 1;
	int remainder;
	String pingPong;
	static Object lock = new Object();

	PrintPingPong(int remainder, String pingPong) {
		this.remainder = remainder;
		this.pingPong = pingPong;
	}

	@Override
	public void run() {
		while (number < noOfTimesToBePrinted) {
			synchronized (lock) {
				while (number % 2 != remainder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + pingPong);
				number++;
				lock.notifyAll();
			}
		}
	}
}