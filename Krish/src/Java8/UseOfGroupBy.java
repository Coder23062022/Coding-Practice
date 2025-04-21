package Krish.src.Java8;

//Material: https://www.baeldung.com/java-groupingby-collector

import java.math.BigDecimal;
import java.util.*;
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

        List<src.Java8.Item> items = Arrays.asList(new src.Java8.Item("apple", 10, new BigDecimal("9.99")),
                new src.Java8.Item("banana", 20, new BigDecimal("19.99")), new src.Java8.Item("orange", 10, new BigDecimal("29.99")),
                new src.Java8.Item("watermelon", 10, new BigDecimal("29.99")), new src.Java8.Item("papaya", 20, new BigDecimal("9.99")),
                new src.Java8.Item("apple", 10, new BigDecimal("9.99")), new src.Java8.Item("banana", 10, new BigDecimal("19.99")),
                new src.Java8.Item("apple", 20, new BigDecimal("9.99")));

        Map<String, Long> counting = items.stream()
                .collect(Collectors.groupingBy(src.Java8.Item::getName, Collectors.counting()));

        System.out.println(counting);

        Map<String, Integer> sum = items.stream()
                .collect(Collectors.groupingBy(src.Java8.Item::getName, Collectors.summingInt(src.Java8.Item::getQty)));

        System.out.println(sum);

        // group by price, uses 'mapping' to convert List<Item> to Set<String>
        Map<BigDecimal, Set<String>> result1 = items.stream()
                .collect(Collectors.groupingBy(src.Java8.Item::getPrice, Collectors.mapping(src.Java8.Item::getName, Collectors.toSet())));

        System.out.println(result1);
    }
}