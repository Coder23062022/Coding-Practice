package Strings;

public class ReverseACharArray {
	public static void main(String[] args) {
		char[] array = { 'I', ' ', 'l', 'i', 'v', 'e', ' ', 'i', 'n', ' ', 'I', 'n', 'd', 'i', 'a' };
		// reverse(array, 0, array.length - 1);
		// System.out.println(array);
		reverseSentence(array);
		System.out.println(array);
	}

	static void reverseSentence(char[] array) {
		int n = array.length;
		reverse(array, 0, n - 1);
		int start = 0;
		for (int i = 0; i < n; i++) {
			if (array[i] == ' ') {
				// Reversing each word
				reverse(array, start, i - 1);
				start = i + 1;
			}
		}
	}

	static void reverse(char[] arr, int start, int end) {
		while (start < end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}