package hard._3041_Maximize_Consecutive_Elements_in_an_Array_After_Modification;

import annotations.Hard;

import java.util.Arrays;

@Hard
public class Solution {

    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        int maxNum = nums[nums.length - 1];

        int[] dp = new int[maxNum + 2];

        for (int num: nums) {
            dp[num + 1] = dp[num] + 1;
            dp[num] = dp[num - 1] + 1;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
