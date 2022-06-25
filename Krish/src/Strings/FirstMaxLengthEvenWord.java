package src.Strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FirstMaxLengthEvenWord {
	public static void main(String[] args) {
		String str = "geeksforgeeks is a platform for geeks";
		System.out.println(findMaxLenEven(str));
		System.out.println(findMaxLenEvenUsingJava8(str));
	}

	private static String findMaxLenEvenUsingJava8(String str) {
		return Arrays.stream(str.split(" ")).filter(x -> x.length() % 2 == 0).max(Comparator.comparing(String::length))
				.get();
	}

	private static String findMaxLenEven(String str) {
		String s[] = str.split(" ");
		Set<String> hs = new HashSet<String>();
		for (int i = 0; i < s.length; i++) {
			if (s[i].length() % 2 == 0) {
				hs.add(s[i]);
			}
		}

		Iterator<String> i = hs.iterator();
		int maxWordLength = 0;
		String result = " ", currWord = " ";
		while (i.hasNext()) {
			currWord = i.next().toString();
			if (currWord.length() > maxWordLength) {
				maxWordLength = currWord.length();
				result = currWord;
			}
		}
		return result;
	}
}