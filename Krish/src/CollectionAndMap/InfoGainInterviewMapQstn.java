package src.CollectionAndMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class InfoGainInterviewMapQstn {

	public static void main(String[] args) {
		String key1 = "Marks";
		String key2 = "Salary";
		String key3 = "Category";
		Map<String, Map<String, Object>> myMap = new HashMap<>();

		Map<String, Object> testMap = new HashMap<>();
		testMap.put(key1, 100);
		testMap.put(key2, 200);
		testMap.put(key3, "Student");

		Map<String, Object> testMap1 = new HashMap<>();
		testMap1.put(key1, 110);
		testMap1.put(key2, 210);
		testMap1.put(key3, "Staff");

		Map<String, Object> testMap2 = new HashMap<>();
		testMap2.put(key1, 120);
		testMap2.put(key2, 220);
		testMap2.put(key3, "Student");

		Map<String, Object> testMap3 = new HashMap<>();
		testMap3.put(key1, 130);
		testMap3.put(key2, 230);
		testMap3.put(key3, "Staff");

		myMap.put("A", testMap);
		myMap.put("B", testMap1);
		myMap.put("C", testMap2);
		myMap.put("D", testMap3);

		// 230, 210, 120, 100

		List<Object> filteredList = new ArrayList<>();

		for (Entry<String, Map<String, Object>> kMap : myMap.entrySet()) {

			if (kMap.getValue().get(key3).equals("Staff")) {
				filteredList.add(kMap.getValue().get(key2));

			} else if (kMap.getValue().get(key3).equals("Student")) {
				filteredList.add(kMap.getValue().get(key1));
			}
		}
		System.out.println(filteredList.stream().sorted().collect(Collectors.toList()));
	}
}