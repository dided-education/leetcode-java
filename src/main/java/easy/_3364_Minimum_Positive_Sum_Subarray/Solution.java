package easy._3364_Minimum_Positive_Sum_Subarray;

import annotations.Easy;

import java.util.List;

@Easy
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int[] prefixSum = new int[nums.size() + 1];

        for (int i = 0; i < nums.size(); i++) {
            prefixSum[i + 1] = prefixSum[i] + nums.get(i);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            for (int len = l; len <= r; len++) {
                int j = i + len;

                if (j > prefixSum.length - 1) {
                    break;
                }
                int sum = prefixSum[j] - prefixSum[i];
                if (sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}