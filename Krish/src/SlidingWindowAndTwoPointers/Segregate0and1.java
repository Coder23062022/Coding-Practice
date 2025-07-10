package Krish.src.SlidingWindowAndTwoPointers;

//Time complexity: O(n)
//Space complexity: O(1)

public class Segregate0and1 {
    public static void main(String[] args) {
        int[] array = {0, 1, 0, 1, 1, 1};
        segregate0and1(array);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    static void segregate0and1(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] == 1) {
                // swap
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                right--;
            } else {
                left++;
            }
        }
    }
}