package src.Greedy;

public class MaxLengthOfSubArrayWithPositiveProduct {
    public static void main(String[] args) {
        int[] nums = {1, -2, -3, 4};
//        int[] nums = {0, 1, -2, -3, -4};
        System.out.println("Maximum length of subarray with positive product is: " + getMaxLen(nums));
    }

    static int getMaxLen(int[] nums) {
        int positive = 0, negative = 0, result = 0;
        for (int num : nums) {
            if (num == 0) {
                positive = 0;
                negative = 0;
            } else if (num > 0) {
                positive++;
                negative = negative == 0 ? 0 : negative + 1;
            } else {
                int temp = positive;
                positive = negative == 0 ? 0 : negative + 1;
                negative = temp + 1;
            }
            result = Math.max(result, positive);
        }
        return result;
    }
}
