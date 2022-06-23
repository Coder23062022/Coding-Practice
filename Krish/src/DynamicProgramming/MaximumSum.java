package DynamicProgramming;

public class MaximumSum {
    /*Function to return max sum such that no two elements are adjacent */
    //Source: https://www.youtube.com/watch?v=UtGtF6nc35g
    int FindMaxSum(int[] arr) {
        int incl = arr[0];
        int excl = 0;

        for (int i = 1; i < arr.length; i++) {
            int temp = incl; //Storing the old inclusive to temp.
            incl = Math.max(incl, excl + arr[i]); //Formula to calculate the new inclusive.
            excl = temp; //New exclusive will be the old inclusive.
        }
        return incl;
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        MaximumSum sum = new MaximumSum();
//        int[] arr = new int[]{5, 20, 25, 11};
        int[] arr = new int[]{4, 1, 1, 4, 2, 1};
        System.out.println(sum.FindMaxSum(arr));
    }
}