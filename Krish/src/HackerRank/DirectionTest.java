package src.HackerRank;

//Source: https://www.codewars.com/kata/550f22f4d758534c1100025a/java
public class DirectionTest {
	public static final String N = "NORTH";
	public static final String S = "SOUTH";
	public static final String E = "EAST";
	public static final String W = "WEST";

	public static void main(String[] args) {
//		String[] directionInput = new String[] { "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };
		String[] directionInput = { "NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST" };
		String[] finalArray = dirReduc(directionInput);
		for (int i = 0; i < finalArray.length; i++) {
			if (finalArray[i] != null)
				System.out.println(finalArray[i]);
		}
	}

	private static String[] dirReduc(String[] input) {
		String[] output = new String[input.length];
		String str = "";
		int count = 0;
		for (int i = 0; i < input.length - 1; i++) {
			if ((N.equals(input[i]) && S.equals(input[i + 1])) || (S.equals(input[i]) && N.equals(input[i + 1]))
					|| (E.equals(input[i]) && W.equals(input[i + 1]))
					|| (W.equals(input[i]) && E.equals(input[i + 1]))) {
				input[i] = null;
				input[i + 1] = null;
				count++;
			}
		}
		if (count != 0) {
			for (int i = 0; i < input.length; i++) {
				if (input[i] != null)
					str = str + input[i] + " ";
			}
			output = str.split(" ");
			dirReduc(output);
		}
		return output;
	}
}