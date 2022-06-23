package Strings;

public class RunLength_Encoding {
	public static void main(String[] args) {
		// I/P: AAAAABBCCAA
		// O/P: 5A2B2C2A
		String str = "AAAAABBCCAA";
		lengthEncode(str);
	}

	private static void lengthEncode(String str) {
		int n = str.length();
		for (int i = 0; i < n; i++) {
			int count = 1;
			while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
				count++;
				i++;
			}
			System.out.print(count + "" + str.charAt(i));
		}
	}
}
