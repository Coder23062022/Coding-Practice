package src.CollectionAndMap;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

enum Name {
	Alice, Smith, Bob, Jones
}

public class SortOnEnumValuesUsingTreeSet {
	public static void main(String[] args) {
		Set<Name> obj = new TreeSet<>(Comparator.comparing(Enum::name));
		obj.add(Name.Alice);
		obj.add(Name.Smith);
		obj.add(Name.Bob);

		Set<String> set = new TreeSet<>();
		set.add("Alice");
		set.add("Smith");
		set.add("Bob");

		System.out.println("Enum set:");
		for (Name d : obj) {
			System.out.println(d);
		}

		System.out.println("\nNormal tree set:");
		for (String d : set) {
			System.out.println(d);
		}
	}
}
