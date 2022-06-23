package Array;

public class Segregate0and1 {
	public static void main(String[] args) {
		int[] array = { 0, 1, 0, 1, 1, 1 };
		segregate0and1(array);
		for (int a : array) {
			System.out.print(a + " ");
		}
	}

	static void segregate0and1(int arr[]) {
		int i = 0, j = arr.length - 1;
		while (i < j) {
			if (arr[i] == 1) {
				// swap
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j--;
			} else {
				i++;
			}
		}
	}
}