package src.CollectionAndMap;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortHashMapByValues {
	public static void main(String[] args) {
		Map<String, Integer> hm = new HashMap<String, Integer>();

		// enter data into hashmap
		hm.put("Math", 98);
		hm.put("Data Structure", 85);
		hm.put("Database", 91);
		hm.put("Java", 95);
		hm.put("Operating System", 79);
		hm.put("Networking", 80);
		Map<String, Integer> hm1 = sortByValue2(hm);

		// print the sorted hashmap
		for (Map.Entry<String, Integer> en : hm1.entrySet()) {
			System.out.println(en.getKey() + " " + en.getValue());
		}
	}

	// function to sort hashmap by values
	private static Map<String, Integer> sortByValue1(Map<String, Integer> hm) {
		Map<String, Integer> temp = hm.entrySet().stream().sorted((i1, i2) -> i1.getValue().compareTo(i2.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		return temp;
	}

	// function to sort hashmap by values
	public static Map<String, Integer> sortByValue2(Map<String, Integer> hm) {
		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// put data from sorted list to hashmap
		Map<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}
}