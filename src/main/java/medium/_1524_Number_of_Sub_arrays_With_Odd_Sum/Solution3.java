package medium._1524_Number_of_Sub_arrays_With_Odd_Sum;

import annotations.Medium;

@Medium
public class Solution3 {

    private final int MOD = 1_000_000_007;

    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        long answer = 0;

        int[] oddPrefixNumber = new int[n];
        if (arr[0] % 2 == 1) {
            oddPrefixNumber[0] = 1;
            answer++;
        }

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
            if (prefixSum[i] % 2 == 1) {
                oddPrefixNumber[i] = oddPrefixNumber[i - 1] + 1;
            } else {
                oddPrefixNumber[i] = oddPrefixNumber[i - 1];
            }

            if (prefixSum[i] % 2 == 0) {
                answer += oddPrefixNumber[i - 1];
            } else {
                answer += (i + 1 - oddPrefixNumber[i - 1]);
            }

            answer %= MOD;
        }

        return (int) answer;
    }
}
