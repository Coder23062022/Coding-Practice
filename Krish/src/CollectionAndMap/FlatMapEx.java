package src.CollectionAndMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapEx {

	public static void main(String[] args) {
		
		//How flatMap() works?
		//{ {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}
		//{ {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
		
		List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)) // Stream of List<Integer>
	            .flatMap(List::stream).map(integer -> integer + 1).collect(Collectors.toList());
		
		System.out.println(together);
	}
}
