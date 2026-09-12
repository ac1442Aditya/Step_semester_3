package arrays.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first position
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    triplets.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicate values for the second and third positions
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        printTriplets(threeSum(nums1)); // [-1, -1, 2] and [-1, 0, 1]

        int[] nums2 = {0, 0, 0};
        printTriplets(threeSum(nums2)); // [0, 0, 0]
    }

    private static void printTriplets(int[][] triplets) {
        for (int[] triplet : triplets) {
            System.out.println(Arrays.toString(triplet));
        }
    }
}
