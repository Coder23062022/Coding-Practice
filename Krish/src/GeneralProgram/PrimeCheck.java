package src.GeneralProgram;

import java.util.Scanner;

public class PrimeCheck {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number:");
		int number = sc.nextInt();

		if (number <= 1)
			System.out.println("Number is not prime");
		else if (number == 2)
			System.out.println("Number is prime");
		else if (number % 2 == 0)
			System.out.println("Number is not prime");
		else
			isPrimeMethod2(number);
	}

	private static void isPrimeMethod1(int number) {
		for (int i = 3; i < number; i++) {
			if (number % i == 0) {
				System.out.println("Number is not prime");
				System.exit(0);
			}
		}
		System.out.println("Number is prime");
	}

	private static void isPrimeMethod2(int number) {
		for (int i = 3; i <= Math.sqrt(number); i += 2) {
			if (number % i == 0) {
				System.out.println("Number is not prime");
				System.exit(0);
			}
		}
		System.out.println("Number is prime");
	}
}