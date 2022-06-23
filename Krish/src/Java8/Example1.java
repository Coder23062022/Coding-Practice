package Java8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Example1 {
	public static void main(String[] args) {
		// Example 1
		Supplier<String> i = () -> "Car";
		Consumer<String> c = x -> System.out.println(x.toLowerCase());
		Consumer<String> d = x -> System.out.println(x.toUpperCase());
		c.andThen(d).andThen(c).accept(i.get()); // andThen is used for chain operation and accept is used to only
													// accept argument.

		// Example 2
		LocalDate localDate = LocalDate.of(2015, 4, 4);
		System.out.println(localDate.format(DateTimeFormatter.ofPattern("E, MMM dd, yyyy")));

		// Example 3
		List<String> letters = new ArrayList<>(Arrays.asList("D", "B", "A", "C", "F", "G"));
		Predicate<String> p1 = s -> s.compareTo("C") > 0; // false for A and B
		Predicate<String> p2 = s -> s.equals("B"); // true for only B
		letters.removeIf(p1.negate().or(p2));
		letters.sort((s1, s2) -> s1.compareTo(s2));
		System.out.println(letters);

		// Example 4 : limit() and skip()
		System.out.println("Limit and skip example:");
		Stream.iterate(0, x -> x + 1).limit(10).skip(5).forEach(System.out::println);

		// Example 5 : spliterator - trySplit() and forEachRemaining()
		System.out.println("Spliterator example:");
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		Spliterator<Integer> splitr1 = list.stream().spliterator();
		Spliterator<Integer> splitr2 = splitr1.trySplit();
		System.out.println("splitr1 contains:");
		splitr1.forEachRemaining(System.out::println);
		System.out.println("splitr2 contains:");
		splitr2.forEachRemaining(System.out::println);

		// Example 6 : startsWith()
		Stream.of("ABC", "DEF", "Amn").filter(x -> x.startsWith("A")).forEach(x -> System.out.println(x));

		// Example 7 : chars() function to print each character's ASCII value in a
		// String.
		final String str = "test";
		str.chars().forEach(ch -> System.out.println(ch));

		// Example 8 : Use of Optional to avoid null values.
		Optional<String> opt = Optional.of("Tom");
		opt = Optional.ofNullable(null);
		System.out.println(opt.isPresent());
		System.out.println(opt.orElseGet(() -> "none"));
		System.out.println(opt.map(s -> "Hey" + s + "!").orElse("Stranger"));
	}
}