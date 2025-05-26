package Krish.src.StackAndQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

//Problem: https://leetcode.com/problems/car-fleet/
//video source: https://www.youtube.com/watch?v=Pr6T-3yB9RM&ab_channel=NeetCode
//Time complexity: O(nlogn)
//Space complexity: O(n)

public class CarFleet {
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(carFleet(target, position, speed));
    }

    static int carFleet(int target, int[] position, int[] speed) {
        // Number of cars
        int n = position.length;

        // Create pairs of position and speed
        double[][] pair = new double[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        // Sort the pairs based on position in ascending order
        Arrays.sort(pair, Comparator.comparingDouble(a -> a[0]));

        // Stack to keep track of car fleets
        Stack<Double> stack = new Stack<>();

        // Iterate from the car closest to the target to the farthest
        for (int i = n - 1; i >= 0; i--) {
            // Calculate the time it takes for the current car to reach the target
            double time = (target - pair[i][0]) / pair[i][1];

            // If the stack is not empty and the current car will reach the target
            // earlier or at the same time as the car at the top of the stack, it means
            // the current car will join the fleet of the car at the top of the stack
            if (!stack.isEmpty() && time <= stack.peek()) {
                continue; // Current car joins the fleet of the car at the top of the stack
            }

            // If the current car does not join any existing fleet, push its time to the stack
            stack.push(time);
        }

        // The size of the stack represents the number of car fleets
        return stack.size();
    }
}