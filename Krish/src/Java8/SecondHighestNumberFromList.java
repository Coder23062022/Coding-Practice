package src.Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondHighestNumberFromList {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, 2, 4, 1, 5);
		System.out.println("Second highest number is: "
				+ list.stream().sorted(Comparator.reverseOrder()).skip(1).limit(1).findFirst().get());
//		System.out.println("Second highest number is: "
//				+ list.stream().sorted(Comparator.reverseOrder()).limit(2).skip(1).findFirst().get());
	}
}
