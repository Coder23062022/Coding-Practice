package src.HackerRank;

//Source: https://www.chegg.com/homework-help/questions-and-answers/1-dam-design-company-designing-dam-built-across-stream-create-small-lake-reduce-materials--q59671847

import java.util.ArrayList;
import java.util.List;

public class DamDesign {
	public static void main(String[] args) {
		List<Integer> wallPositions = new ArrayList<>();
		wallPositions.add(1);
		wallPositions.add(2);
		wallPositions.add(4);
		wallPositions.add(7);

		List<Integer> wallHeights = new ArrayList<>();
		wallHeights.add(4);
		wallHeights.add(6);
		wallHeights.add(8);
		wallHeights.add(11);

		System.out.println(maxHeight(wallPositions, wallHeights));
	}

	public static int maxHeight(List<Integer> wallPositions, List<Integer> wallHeights) {
		Integer wallPositionsArr[] = new Integer[wallPositions.size()];
		wallPositionsArr = wallPositions.toArray(wallPositionsArr);

		Integer wallHeightsArr[] = new Integer[wallHeights.size()];
		wallHeightsArr = wallHeights.toArray(wallHeightsArr);

		int n = wallPositionsArr.length;
		int mud_max = 0;

		for (int i = 0; i < n - 1; i++) {
			if (wallPositionsArr[i] < (wallPositionsArr[i + 1] - 1)) {
				// we have a gap
				int heightDiff = Math.abs(wallHeightsArr[i + 1] - wallHeightsArr[i]);
				int gaplen = wallPositionsArr[i + 1] - wallPositionsArr[i] - 1;
				int localMax = 0;
				if (gaplen > heightDiff) {
					int low = Math.max(wallHeightsArr[i + 1], wallHeightsArr[i]) + 1;
					int remainingGap = gaplen - heightDiff - 1;
					localMax = low + remainingGap / 2;
				} else {
					localMax = Math.min(wallHeightsArr[i + 1], wallHeightsArr[i]) + gaplen;
				}
				mud_max = Math.max(mud_max, localMax);
			}
		}
		return mud_max;
	}
}