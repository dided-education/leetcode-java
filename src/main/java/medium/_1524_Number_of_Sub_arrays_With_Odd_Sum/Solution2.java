package medium._1524_Number_of_Sub_arrays_With_Odd_Sum;

import annotations.Medium;

@Medium
public class Solution2 {

    private final int MOD = 1_000_000_007;

    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        long answer = 0;

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                int sumOfSubArray = prefixSum[i] - prefixSum[j];
                if (sumOfSubArray % 2 == 1) {
                    answer++;
                }

                answer %= MOD;
            }
        }

        return (int) answer;
    }
}