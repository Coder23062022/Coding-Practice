package Krish.src.Java8;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseAString {
    public static void main(String[] args) {
        String str = "Stream";
        System.out.println(str.chars().mapToObj(c -> String.valueOf((char) c))
                .reduce("", (s, c) -> c + s));
        System.out.println(IntStream.range(0, str.length()).mapToObj(i -> str.charAt(str.length() - i - 1))
                .map(String::valueOf).collect(Collectors.joining()));
    }
}