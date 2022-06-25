package src.Strings;

public class CaesarCipher {
	public static void main(String[] args) {
		System.out.println(encrypt("VGXPZ", 3));
	}

	private static StringBuffer encrypt(String str, int shift) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				char ch = (char) ((((int) str.charAt(i)) + shift - 65) % 26 + 65);

				// For Counter-Clockwise direction shifting
//				char ch = (char) ((((int) str.charAt(i)) - shift + 65) % 26 + 65);

				result.append(ch);
			} else {
				char ch = (char) ((((int) str.charAt(i)) + shift - 97) % 26 + 97);

				// For Counter-Clockwise direction shifting
//				char ch = (char) ((((int) str.charAt(i)) - shift + 97) % 26 + 97);

				result.append(ch);
			}
		}
		return result;
	}
}