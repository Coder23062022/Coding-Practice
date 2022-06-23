package Thread;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyTest {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Java");
        names.add("PHP");
        names.add("SQL");
        names.add("Angular 2");

        List<String> first2Names = names.subList(0, 2); // subList does not contain the value of last index

        System.out.println(names + " , " + first2Names);

        names.set(1, "JavaScript");
        // check the output below. :)
        System.out.println(names + " , " + first2Names + "\n"); // modification of existing list does not throw ConcurrentModificationException

        // Let's modify the list size and get ConcurrentModificationException
        names.add("NodeJS");
        System.out.println(names + " , " + first2Names); // this line throws exception
    }
}
