package Krish.src.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MergeTwoLists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(5, 6, 7, 8);

        List<Integer> mergedList1 = Stream.of(list1, list2).flatMap(List::stream).toList();
        System.out.println(mergedList1);

        List<Integer> mergedList2 = Stream.concat(list1.stream(), list2.stream()).toList();
        System.out.println(mergedList2);
    }
}