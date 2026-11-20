package medium._2567_Minimum_Score_by_Changing_Two_Elements;

import annotations.Medium;

import java.util.Arrays;

@Medium
public class Solution {

    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int firstMax = nums[n - 1];
        int secondMax = nums[n - 2];
        int thirdMax = nums[n - 3];
        int firstMin = nums[0];
        int secondMin = nums[1];
        int thirdMin = nums[2];

        return Math.min(Math.min(firstMax - thirdMin, thirdMax - firstMin), secondMax - secondMin);
    }
}
