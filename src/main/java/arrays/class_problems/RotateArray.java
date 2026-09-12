package arrays.class_problems;

import java.util.Arrays;

public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {
        int length = nums.length;
        k = k % length;

        int[] newArray = new int[length];

        for (int i = 0; i < length; i++) {
            newArray[(i + k) % length] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(rotateArray(nums1, 3))); // [5, 6, 7, 1, 2, 3, 4]

        int[] nums2 = {1, 2};
        System.out.println(Arrays.toString(rotateArray(nums2, 3))); // [2, 1]
    }
}
