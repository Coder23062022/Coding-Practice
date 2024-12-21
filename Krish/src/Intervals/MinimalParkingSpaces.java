package Krish.src.Intervals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

//Problem: https://leetcode.com/discuss/interview-question/650066/Minimum-Parking-Space

public class MinimalParkingSpaces {
    static int minParkingSpaces(int[][] parkingStartEndTimes) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] parkingStartEndTime : parkingStartEndTimes) {
            if (map.containsKey(parkingStartEndTime[0]))
                map.put(parkingStartEndTime[0], map.get(parkingStartEndTime[0]) + 1);
            else {
                map.put(parkingStartEndTime[0], 1);
            }
            if (map.containsKey(parkingStartEndTime[1]))
                map.put(parkingStartEndTime[1], map.get(parkingStartEndTime[1]) - 1);
            else {
                map.put(parkingStartEndTime[1], -1);
            }
        }
        int ans = 0, count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        int[][] parkingStartEndTimeList = new int[n][2];
        String[] parkingStartEndTimes = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
            for (int j = 0; j < parkingStartEndTime.length; j++) {
                parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
            }
        }

        int out = minParkingSpaces(parkingStartEndTimeList);
        System.out.println(out);

        wr.close();
        br.close();
    }
}