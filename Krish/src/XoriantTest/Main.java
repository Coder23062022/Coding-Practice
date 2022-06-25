package src.XoriantTest;

//Consider this Java Program. It reads integers from the standard input (until it gets a negative number) and puts them into an array.
//After that it calls processArray on the array, and then prints the contents of the array on standard output. Currently, processArray does not modify the array.
//You have to change this program so that any sequence of two or more consecutive numbers greater than or equal to 100 in the array are removed from the array 
//and replaced by a single number representing the length of that sequence. 
//The processArray method should modify the array in-place (preferably without creating a new array), and it should return the new length of the modified array.

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static int processArray(ArrayList<Integer> array) {
		int count = 0;
		for (int i = 0; i < array.size(); i++) {
			if ((array.get(i) % 2) != 0) // odd
			{
				count++;
				if (count > 1) {
					array.set(i, count);
					array.remove(i - 1);
					if (i > 0)
						i = i - 1;
					else
						i = 0;
				}
			} else {
				count = 0;
			}
		}
		return array.size();
	}

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int num = in.nextInt();
			if (num < 0)
				break;
			arrayList.add(new Integer(num));
		}
		int new_length = processArray(arrayList);
		for (int i = 0; i < new_length; i++)
			System.out.println(arrayList.get(i));
	}
}