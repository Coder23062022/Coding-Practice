package GeneralProgram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindWordInAFile {
	@SuppressWarnings("resource")
	public static void main(String args[]) throws FileNotFoundException {
		// Reading the word to be found from the user
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter the word to be found");
		String word = sc1.next();
		boolean flag = false;
		int count = 0;
		System.out.println("\nContents of the line");
		// Reading the contents of the file
		Scanner sc2 = new Scanner(new FileInputStream("E:\\sampleData.txt"));
		while (sc2.hasNextLine()) {
			String line = sc2.nextLine();
			String str[] = line.split(" ");
			System.out.println(line);

			for (String s : str) {
				if (word.equals(s)) {
//				if (s.contains(word)) {
					flag = true;
					count++;
				}
			}
			// indexOf we can't use because in the file, if any word contains 'the' it will
			// accept that also. indexOf and contains don't check for whole word.
//			if (line.indexOf(word) != -1) {
//				flag = true;
//				count = count + 1;
//			}
		}
		if (flag) {
			System.out.println("\nFile contains the specified word");
			System.out.println("Number of occurrences is: " + count);
		} else {
			System.out.println("File does not contain the specified word");
		}
	}
}