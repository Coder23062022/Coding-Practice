package Krish.src.Java8;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EveryCharCountInAString {
    public static void main(String[] args) {
        String str = "abcdabcghsk";

        System.out.println(str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        System.out.println(Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }
}