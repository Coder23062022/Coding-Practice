package src.Thread;

//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationExceptionExample {
	public static void main(String args[]) {
		
		//Here we are using CopyOnWriteArrayList for List and ConcurrentHashMap for Map to avoid ConcurrentModificationException
		//If you will put ArrayList and HashMap instead of CopyOnWriteArrayList and ConcurrentHashMap, you will get ConcurrentModificationException
		
		List<String> myList = new CopyOnWriteArrayList<String>();
		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");

		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println("List Value:" + value);
			if (value.equals("3"))
				myList.remove(value);
		}

		Map<String, String> myMap = new ConcurrentHashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			System.out.println("Map Value:" + myMap.get(key));

			/*for(Map.Entry m : myMap.entrySet()) {
				System.out.println(m.getKey() + " " + m.getValue());
			}*/

			if (key.equals("2")) {
				myMap.put("3", "4");
				myMap.put("4", "4");
			}
		}
	}
}