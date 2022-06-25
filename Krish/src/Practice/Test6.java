package src.src.Practice;

public class Test6 {
	public static void main(String[] args) {
		String arr[] = { "abc", "cba", "lls", "s" };
		checkPal(arr, arr.length);

	}

	static void checkPal(String a[], int n) {
		for (int i = 0; i < n; i++) {
			String s1 = a[i];
			for (int j = 0; j < n; j++) {
				if (i != j) {
					String s2 = s1.concat(a[j]);
					if (checkPalindrome(s2)) {
						System.out.println(i + "," + j);
					}
				}
			}
		}
	}

	static boolean checkPalindrome(String s) {
		StringBuffer sb = new StringBuffer(s);
		sb.reverse();
		return s.equals(sb.toString());
	}
}