package Strings;

import java.util.Arrays;

public class Stringsplit {

	public static void main(String[] args) {


		/**
		 * Java String split example
		 * 
		 * @param args
		 */
		String line = "I am a java developer";

		String[] words = line.split(" ");

		String[] twoWords = line.split(" ", 2);

		System.out.println("String split with delimiter: " + Arrays.toString(words));

		System.out.println("String split into two: " + Arrays.toString(twoWords));

		// split string delimited with special characters
		String wordsWithNumbers = "I|am|a|java|developer";

		String[] numbers = wordsWithNumbers.split("\\|");

		System.out.println("String split with special character: " + Arrays.toString(numbers));

	}

}
