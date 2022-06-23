package Strings;

public class FindKeyInAStringWithoutUsingLibraryFunction {
	public static void main(String[] args) {
		String s = "Interview with Krish";
		String s1 = "with Krish";
		System.out.println(contains(s, s1));
	}

	static boolean contains(String s, String key) {
		if (s == null || s.isEmpty() || key == null || key.isEmpty() || key.length() > s.length())
			return false;
		char ch1[] = s.toCharArray();
		char ch2[] = key.toCharArray();
		int keyLength = key.length();

		for (int i = 0; i < s.length(); i++) {
			int j = 0;
			if (ch1[i] == ch2[j]) {
				i++;
				j++;
				while (keyLength - 1 != 0) {
					if (i < s.length() && j < key.length() && ch1[i] == ch2[j]) {
						i++;
						j++;
						keyLength--;
					} else
						break;
				}
			}
			if (j == key.length())
				return true;
		}
		return false;
	}
}