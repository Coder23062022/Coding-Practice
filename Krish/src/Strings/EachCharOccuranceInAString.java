package src.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EachCharOccuranceInAString {
	public static void highestOccuredCharacter(String word) {
		int max = 0;
		Character result = ' ';
		char character[] = word.toCharArray();
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		for (Character ch : character) {
			if (charMap.containsKey(ch)) {
				charMap.put(ch, charMap.get(ch) + 1);
			} else {
				charMap.put(ch, 1);
			}
		}

		for (Map.Entry<Character, Integer> itr : charMap.entrySet()) {
			// System.out.println(itr.getKey() + " " + itr.getValue());
			if (itr.getValue() > max) {
				max = itr.getValue();
				if (charMap.containsValue(max)) {
					result = itr.getKey();
				}
			}
		}
		System.out.print("Maximum Occured Character is '" + result + "'");
		System.out.print(" with count : " + max);

		Set<Entry<Character, Integer>> entrySet = charMap.entrySet();
		System.out.println("\nList of duplicate character of " + word);
		for (Map.Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue() > 1) {
				System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
			}
		}
	}

	public static void main(String a[]) {
		String word = "Krishnendu Banerjee";
		highestOccuredCharacter(word);
	}
}