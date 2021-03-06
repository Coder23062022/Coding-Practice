package src.CollectionAndMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatmapDemo {
	public static void main(String[] args) {

		List<String> houseGryffindor = Arrays.asList("Albus", "Harry", "Ron", "Hermione");
		List<String> houseHufflepuff = Arrays.asList("Bridget", "Cedric", "Nymphadora");
		List<String> houseRavenclaw = Arrays.asList("Luna", "Garrick", "Filius");
		List<String> houseSlytherin = Arrays.asList("Severus", "Tom", "Phineas");

		List<List<String>> hogwarts = new ArrayList<List<String>>();
		hogwarts.add(houseGryffindor);
		hogwarts.add(houseHufflepuff);
		hogwarts.add(houseRavenclaw);
		hogwarts.add(houseSlytherin);

		// Printing All Hogwarts Houses In Pre-Java8 World
		/*
		 * List<String> listOfAllHouses = new ArrayList<>(); for(List<String> house :
		 * hogwarts) { for(String hName : house) { listOfAllHouses.add(hName); } }
		 */

		System.out.println("<!---------------Hogwarts Houses---------------!>");
		System.out.println(hogwarts);
		// System.out.println(listOfAllHouses);

		System.out.println();

		// Now let's Achieve This By Using 'flatMap()' Method In Java8
		// flatMap() is the combination of a map and a flat operation i.e, it applies a
		// function to elements as well as flatten them.
		List<String> flatMapList = hogwarts.stream().flatMap(hList -> hList.stream()).collect(Collectors.toList());

		System.out.println("<!---------------Hogwarts Houses---------------!>");
		System.out.println(flatMapList);
	}
}
