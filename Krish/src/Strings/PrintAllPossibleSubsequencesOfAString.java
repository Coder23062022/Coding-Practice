package Strings;

public class PrintAllPossibleSubsequencesOfAString {
	public static void main(String[] args) {
		String input = "abc";
		String output = "";
		printAllSubSequences(input, output);
	}

	static void printAllSubSequences(String input, String output) {
		if (input.length() == 0) {
			System.out.println(output);
			return;
		}

		char ch = input.charAt(0);
		String newInput = input.substring(1); // Discarding the first character and form a new input

		printAllSubSequences(newInput, output); // For left subtree
		printAllSubSequences(newInput, output + ch); // For right subtree
	}
}