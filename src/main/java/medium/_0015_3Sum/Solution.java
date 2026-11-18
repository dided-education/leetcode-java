package medium._0015_3Sum;

import annotations.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Medium
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int left;
        int right;
        int sum;

        Set<List<Integer>> tempRes = new HashSet<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    tempRes.add(List.of(nums[i], nums[left], nums[right]));
                }
                if (sum < 0) {
                    ++left;
                } else {
                    --right;
                }
            }
        }

        return List.copyOf(tempRes);
    }
}