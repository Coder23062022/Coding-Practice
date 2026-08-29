package src.CollectionAndMap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindMaxAndAverage {
    static void main() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.stream().max(Comparator.comparing(Integer::valueOf)).get());
        System.out.println(list.stream().mapToInt(x -> x).average().orElse(0));
    }
}
