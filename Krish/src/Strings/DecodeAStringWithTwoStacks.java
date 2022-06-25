package src.Strings;

import java.util.Stack;

public class DecodeAStringWithTwoStacks {
	public static void main(String args[]) {
		String str = "3[a]2[bc]"; // 3[a2[c]];
		System.out.println(decodeString(str));
	}

	static String decodeString(String s) {
		int n = s.length();
		Stack<Integer> countStack = new Stack<>();
		Stack<String> charStack = new Stack<>();
		int i = 0;
		String res = "";

		while (i < n) {
			if (Character.isDigit(s.charAt(i))) {
				int count = 0;
				while (Character.isDigit(s.charAt(i))) {
					count = count * 10 + (s.charAt(i) - '0');
					i++;
				}
				countStack.push(count);
			} else if (s.charAt(i) == ']') {
				StringBuilder sb = new StringBuilder(charStack.pop());
				int x = countStack.pop();

				for (int j = 0; j < x; j++) {
					sb.append(res);
				}
				res = sb.toString();
				i++;
			} else if (s.charAt(i) == '[') {
				charStack.push(res);
				res = "";
				i++;
			} else {
				res += s.charAt(i);
				i++;
			}
		}
		return res;
	}
}