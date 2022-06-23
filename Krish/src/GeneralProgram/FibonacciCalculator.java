package GeneralProgram;

import java.util.Scanner;

public class FibonacciCalculator {
	public static void main(String args[]) {
		// input to print Fibonacci series upto how many numbers
		System.out.println("Enter number upto which Fibonacci series to print: ");
		@SuppressWarnings("resource")
		int number = new Scanner(System.in).nextInt();
		int sum = 0;
		System.out.println("Fibonacci series upto " + number + " numbers : ");
		// printing Fibonacci series upto number
		for (int i = 1; i <= number; i++) {
			sum = sum + fibonacci2(i);
			System.out.print(fibonacci2(i) + " ");
		}
		System.out.println("\nSum of the " + number + " numbers is: " + sum);
	}

	public static int fibonacci(int number) {
		if (number == 0 || number == 1) {
			return 0;
		}

		if (number == 2) {
			return 1;
		}

		return fibonacci(number - 1) + fibonacci(number - 2); // tail recursion
	}

	public static int fibonacci2(int number) {
		if (number == 0 || number == 1) {
			return 0;
		}

		if (number == 2) {
			return 1;
		}

		int fibo1 = 0, fibo2 = 1, fibonacci = 0;
		for (int i = 3; i <= number; i++) {
			// Fibonacci number is sum of previous two Fibonacci number
			fibonacci = fibo1 + fibo2;
			fibo1 = fibo2;
			fibo2 = fibonacci;
		}
		return fibonacci;
	}
}
