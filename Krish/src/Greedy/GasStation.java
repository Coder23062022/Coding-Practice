package Krish.src.Greedy;

//Problem: https://leetcode.com/problems/gas-station/
//Video source: https://www.youtube.com/watch?v=SmTow5Ht4iU&t=540s&ab_channel=ShradhaKhapra
//Time Complexity: O(n)
//Space complexity: O(1)

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, startIdx = 0, currGas = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];

            currGas += gas[i] - cost[i];
            if (currGas < 0) {
                startIdx = i + 1;
                currGas = 0;
            }
        }
        return totalGas < totalCost ? -1 : startIdx;
    }

    static int canCompleteCircuitMethod2(int[] gas, int[] cost) {
        int totalGas = 0, startIdx = 0, currGas = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            currGas += gas[i] - cost[i];

            if (currGas < 0) {
                startIdx = i + 1;
                currGas = 0;
            }
        }
        return totalGas < 0 ? -1 : startIdx;
    }
}