package src.Practice;

import java.util.*;

public class Test123 {
    public static void main(String[] args) {
        List<int[]> list = List.of(new int[]{1, 2, 3}, new int[]{2, 3}, new int[]{1, 2, 3}, new int[]{4, 5}, new int[]{1, 2, 3}, new int[]{3, 5}, new int[]{4, 5});
        for (int[] element : removeDuplicates(list)) {
            System.out.println(Arrays.toString(element));
        }
    }

    static List<int[]> removeDuplicates(List<int[]> list) {
        List<int[]> result = new ArrayList<>();
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int[] a1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int[] a2 = list.get(j);
                if (Arrays.equals(a1, a2)) {
                    map.put(a2, j);
                    break;
                }
            }
        }
        for (int[] ints : list) {
            if (!map.containsKey(ints)) {
                result.add(ints);
            }
        }
        return result;
    }
}
