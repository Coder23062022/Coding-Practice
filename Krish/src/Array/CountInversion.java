package Krish.src.Array;

//Problem: https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
//Video source: https://www.youtube.com/watch?v=ynnWDBTdVi0&ab_channel=ShradhaKhapra
//Time complexity: O(nlogn)
//Space complexity: O(n)

public class CountInversion {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        System.out.println(mergeSort(nums, 0, nums.length - 1));
    }

    static int mergeSort(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int mid = start + (end - start) / 2;
        int leftInvCount = mergeSort(nums, start, mid);
        int rightInvCount = mergeSort(nums, mid + 1, end);
        int invCount = merge(nums, start, mid, end);
        return leftInvCount + rightInvCount + invCount;
    }

    static int merge(int[] nums, int start, int mid, int end) {
        int l = start, r = mid + 1;
        int[] temp = new int[end - start + 1];
        int index = 0, invCount = 0;

        while (l <= mid && r <= end) {
            if (nums[l] <= nums[r]) {
                temp[index++] = nums[l];
                l++;
            } else {
                temp[index++] = nums[r];
                r++;
                invCount += mid - l + 1;
            }
        }

        while (l <= mid) {
            temp[index++] = nums[l];
            l++;
        }

        while (r <= end) {
            temp[index++] = nums[r];
            r++;
        }

        for (int i = 0; i < temp.length; i++) {
            nums[i + start] = temp[i];
        }

        return invCount;
    }
}