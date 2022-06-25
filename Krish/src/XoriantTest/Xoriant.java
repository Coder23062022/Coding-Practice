package src.XoriantTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Xoriant {
	public static Map<String, Integer> processData(ArrayList<String> array) {
		String str[];
		int count = 0;
		Map<String, Integer> retVal = new HashMap<String, Integer>();
		int ar[] = new int[100];
		int ar1[] = new int[100];
		int s1 = 0, s2 = 0;
		for (String s : array) {
			str = s.split(",");
			if (str[2].trim().equals("Engineering")) {
				ar[count] = (int) Integer.parseInt(str[3].trim());
				if (s1 <= ar[count])
					s1 = ar[count];
			}
			if (str[2].trim().equals("Testing")) {
				ar1[count] = (int) Integer.parseInt(str[3].trim());
				if (s2 <= ar1[count])
					s2 = ar1[count];
			}
		}
		for (String s : array) {
			str = s.split(",");
			if (s1 == (int) Integer.parseInt(str[3].trim()) && str[2].trim().equals("Engineering")) {
				Integer i = (Integer) Integer.parseInt(str[0].trim());
				retVal.put("Engineering", i);
			}
			if (s2 == (int) Integer.parseInt(str[3].trim()) && str[2].trim().equals("Testing")) {
				Integer i = (Integer) Integer.parseInt(str[0].trim());
				retVal.put("Testing", i);
			}
		}
		return retVal;
	}

	public static void main(String[] args) {
		ArrayList<String> inputData = new ArrayList<String>();
		try {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(new BufferedReader(
					new FileReader("C:\\Users\\krishnandu Banerjee\\Desktop\\\\XoriantTest\\input.txt")));
			while (in.hasNextLine())
				inputData.add(in.nextLine());
			Map<String, Integer> retVal = processData(inputData);
			PrintWriter output = new PrintWriter(new BufferedWriter(
					new FileWriter("C:\\Users\\krishnandu Banerjee\\Desktop\\\\XoriantTest\\output.txt")));
			for (Map.Entry<String, Integer> e : retVal.entrySet())
				output.println(e.getKey() + ": " + e.getValue());
			output.close();
		} catch (IOException e) {
			System.out.println("IO error in input.txt or output.txt");
		}
	}
}