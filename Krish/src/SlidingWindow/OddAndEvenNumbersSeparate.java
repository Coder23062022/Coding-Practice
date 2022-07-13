package src.SlidingWindow;

public class OddAndEvenNumbersSeparate {
    public static void main(String[] args) {
        int[] inputArray = {12, 34, 99, 5, 10, 23, 2, 37}; //12 34 2 10 5 23 99 27

        int left = 0;
        int right = inputArray.length - 1;

        while (left < right) {
            if (inputArray[left] % 2 == 0) {
                left++;
            } else {
                int temp = inputArray[left];
                inputArray[left] = inputArray[right];
                inputArray[right] = temp;
                right--;
            }
        }

        for (int j : inputArray) {
            System.out.print(j + " ");
        }
    }
}