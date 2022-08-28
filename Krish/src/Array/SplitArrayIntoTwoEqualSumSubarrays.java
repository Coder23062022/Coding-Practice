package src.Array;

//Example: 
//Input : Arr[] = { 1 , 2 , 3 , 4 , 5 , 5  }
//Output :  { 1 2 3 4 } 
//			{ 5 , 5 }

public class SplitArrayIntoTwoEqualSumSubarrays {
    static int findSplitPoint(int[] arr) {
        int sum = 0, leftSum = 0;
        //Find out the total sum of all the elements in the array.
        for (int j : arr) {
            sum += j;
        }

        for (int i = 0; i < arr.length; i++) {
            sum = sum - arr[i];
            leftSum += arr[i];
            if (leftSum == sum)
                return i + 1;
        }

        //If no equilibrium index found, then return -1.
        return -1;
    }

    //Prints two parts after finding split point using findSplitPoint()
    static void printTwoParts(int[] arr, int n) {
        int splitPoint = findSplitPoint(arr);

        //splitPoint == n when there is only one element present in the array.
        if (splitPoint == -1 || splitPoint == n) {
            System.out.println("Not Possible");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (splitPoint == i)
                System.out.println();

            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5};
//        int[] arr = {1, 5, 11, 5};
        int n = arr.length;
        printTwoParts(arr, n);
    }
}