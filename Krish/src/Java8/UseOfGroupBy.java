package src.Java8;

//Material: https://www.baeldung.com/java-groupingby-collector

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UseOfGroupBy {
	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

		Map<String, Long> result = fruits.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<String, Long> finalMap = new LinkedHashMap<>();

		// Sort a map and add to finalMap
		result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

		System.out.println(finalMap);

		List<Item> items = Arrays.asList(new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 20, new BigDecimal("19.99")), new Item("orange", 10, new BigDecimal("29.99")),
				new Item("watermelon", 10, new BigDecimal("29.99")), new Item("papaya", 20, new BigDecimal("9.99")),
				new Item("apple", 10, new BigDecimal("9.99")), new Item("banana", 10, new BigDecimal("19.99")),
				new Item("apple", 20, new BigDecimal("9.99")));

		Map<String, Long> counting = items.stream()
				.collect(Collectors.groupingBy(Item::getName, Collectors.counting()));

		System.out.println(counting);

		Map<String, Integer> sum = items.stream()
				.collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

		System.out.println(sum);

		// group by price, uses 'mapping' to convert List<Item> to Set<String>
		Map<BigDecimal, Set<String>> result1 = items.stream()
				.collect(Collectors.groupingBy(Item::getPrice, Collectors.mapping(Item::getName, Collectors.toSet())));

		System.out.println(result1);
	}
}