package src.Array;

//Problem: https://www.geeksforgeeks.org/find-element-array-sum-left-array-equal-sum-right-array/
//Time complexity: O(n)
//Space complexity: O(1)

public class SumOfLeftArrayIsEqualToSumOfRightArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 4, 5};
        System.out.println("The index of the middle element is: " + findElementMethod1(arr));
    }

    static int findElementMethod1(int[] arr) {
        int sum = 0, leftSum = 0;
        //Find out the total sum of all the elements in the array.
        for (int j : arr) {
            sum += j;
        }

        for (int i = 0; i < arr.length; i++) {
            sum = sum - arr[i];
            if (leftSum == sum)
                return i;
            leftSum += arr[i];
        }

        //If no equilibrium index found, then return -1.
        return -1;
    }

    static int findElementMethod2(int[] intArray) {
        int size = intArray.length - 1;
        int mid = (size) / 2;

        while (mid < size) {
            int low = 0;
            int high = intArray.length - 1;
            int leftSum = 0;
            int rightSum = 0;

            while (low < mid) {
                leftSum = leftSum + intArray[low];
                low++;
            }

            while (mid < high) {
                rightSum = rightSum + intArray[high];
                high--;
            }

            if (leftSum == rightSum) {
                System.out.println("The middle element is: " + intArray[mid]);
                return mid;
            } else {
                mid = mid + 1;
            }
        }
        return -1;
    }
}