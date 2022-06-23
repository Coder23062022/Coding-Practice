package CollectionAndMap;

import java.util.*;

/*Task description:
Two non-negative integers are called siblings if they can be obtained from each other by rearranging the digits of their decimal representations.
For example, 123 and 213 are siblings. 535 and 355 are also siblings.

A set consisting of a non-negative integer N and all of its siblings is called the family of N.
For example, the family of 553 comprises three numbers: 355, 535 and 553.

Write a function that, given a non-negative integer N, returns the largest number in the family of N.
The function should return -1 if the result exceeds 100,000,000.

For example, given N = 213 the function should return 321. Given N = 553 the function should return 553.

Write an efficient algorithm for the following assumptions: N is an integer within the range [0..2,147,483,647].
*/

public class HighestSibling {
	public static void main(String[] args) {
		System.out.println(solution(3431334));
	}

	public static int solution(int N) {
		if (N < 0)
			throw new IllegalArgumentException("N should be non-negative number");
		if (N == 0)
			return 0;

		List<Integer> numbers = new ArrayList<Integer>();
		while (N > 0) {
			numbers.add(N % 10);
			N /= 10;
		}

		Collections.sort(numbers, Collections.reverseOrder());

		int result = numbers.get(0);
		for (int i = 1; i < numbers.size(); i++) {
			result = result * 10 + numbers.get(i);
			if (result > 100000000)
				return -1;
		}
		return result;
	}
}