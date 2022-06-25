package src.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		Map<Integer, Integer> map = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toMap(x -> x, x -> x * x));

		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}
}
