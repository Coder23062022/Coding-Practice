package src.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondMostFrequentCharacterInAStringUsingCollection {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        meth(str);
    }

    static void meth(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int n = list.get(list.size() - 2);

        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (m.getValue() == n) {
                System.out.print(m.getKey() + " ");
            }
        }
    }
}