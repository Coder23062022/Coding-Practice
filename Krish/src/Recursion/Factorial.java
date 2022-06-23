package Recursion;

public class Factorial {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(fact(n));
	}

	static int fact(int number) {
		if (number == 0)
			return 1;
		return number * fact(number - 1);
	}
}
