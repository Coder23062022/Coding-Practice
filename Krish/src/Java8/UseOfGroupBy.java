package Krish.src.Java8;

//Material: https://www.baeldung.com/java-groupingby-collector
//Docs: https://salithachathuranga94.medium.com/java-8-streams-groupby-b15054d9e6c8

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UseOfGroupBy {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

        //Fruit count grouped by the item
        Map<String, Long> result = fruits.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);

        //Sort a map and add to finalMap
        Map<String, Long> finalMap = new LinkedHashMap<>();
        result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        System.out.println(finalMap);

        List<Item> items = Arrays.asList(new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")), new Item("orange", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")), new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")), new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99")));

        //Item count grouped by the name
        Map<String, Long> counting = items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
        System.out.println(counting);

        //Item names grouped by the quantity sum
        Map<String, Integer> sum = items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
        System.out.println(sum);

        //Item names grouped by their prices, uses 'mapping' to convert List<Item> to Set<String>
        Map<BigDecimal, Set<String>> result1 = items.stream()
                .collect(Collectors.groupingBy(Item::getPrice, Collectors.mapping(Item::getName, Collectors.toSet())));
        System.out.println(result1);

        //Item names grouped by their sorted prices
        Map<BigDecimal, Set<String>> result2 = items.stream()
                .collect(Collectors.groupingBy(Item::getPrice, TreeMap::new, Collectors.mapping(Item::getName, Collectors.toSet())));
        System.out.println(result2);
    }

    static class Item {
        String name;
        int qty;
        BigDecimal price;

        public Item(String name, int qty, BigDecimal price) {
            this.name = name;
            this.qty = qty;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }
    }
}