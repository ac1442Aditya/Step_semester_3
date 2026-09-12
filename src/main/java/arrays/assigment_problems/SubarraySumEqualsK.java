package arrays.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumFrequency = new HashMap<>();
        prefixSumFrequency.put(0, 1); // empty prefix sums to 0

        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            int needed = currentSum - k;

            if (prefixSumFrequency.containsKey(needed)) {
                count += prefixSumFrequency.get(needed);
            }

            prefixSumFrequency.put(currentSum, prefixSumFrequency.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        System.out.println(subarraySum(nums1, 2)); // 2

        int[] nums2 = {1, -1, 0};
        System.out.println(subarraySum(nums2, 0)); // 3
    }
}
