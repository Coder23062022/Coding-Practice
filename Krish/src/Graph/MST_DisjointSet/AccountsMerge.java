package Krish.src.Graph.MST_DisjointSet;

//Problem: https://leetcode.com/problems/accounts-merge/
//Video source: https://www.youtube.com/watch?v=FMwpt_aQOGw&ab_channel=takeUforward
//Time complexity: O(nk * log(nk)), where n * k is total number of emails. (Because sorting takes nlogn time, here n is n * k)
//Space complexity: O(n * k)

import java.util.*;

public class AccountsMerge {
    public static void main(String[] args) {
        List<List<String>> accounts = List.of(List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"), List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("Mary", "mary@mail.com"), List.of("John", "johnnybravo@mail.com"));
        System.out.println(Arrays.toString(accountsMerge(accounts).toArray()));
    }

    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet.DisjointUnionSets dus = new DisjointSet.DisjointUnionSets(n);

        //Create a map with emails and node number (email -> node)
        Map<String, Integer> mailNodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!mailNodeMap.containsKey(mail)) {
                    mailNodeMap.put(mail, i);
                } else {
                    dus.unionBySize(i, mailNodeMap.get(mail));
                }
            }
        }

        //Create a list with emails under the same parent node (node -> [array of emails])
        List<String>[] nodeMailList = new ArrayList[n];
        for (int i = 0; i < n; i++) nodeMailList[i] = new ArrayList<>();
        for (Map.Entry<String, Integer> hm : mailNodeMap.entrySet()) {
            String mail = hm.getKey();
            int node = dus.find(hm.getValue());
            nodeMailList[node].add(mail);
        }

        //Create the result list. Sort the email list one by one and attach it with the corresponding name.
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!nodeMailList[i].isEmpty()) {
                Collections.sort(nodeMailList[i]);
                List<String> temp = new ArrayList<>();
                temp.add(accounts.get(i).get(0));
                temp.addAll(nodeMailList[i]);
                res.add(temp);
            }
        }
        return res;
    }
}