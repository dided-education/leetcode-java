package medium._1524_Number_of_Sub_arrays_With_Odd_Sum;

import annotations.Medium;

@Medium
public class Solution {

    private final int MOD = 1_000_000_007;

    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        long answer = 0;

        int oddPrefixNumber = 0;
        int prefixSum = 0;

        for (int i = 0; i < n; ++i) {

            prefixSum += arr[i];

            if (prefixSum % 2 == 0) {
                answer += oddPrefixNumber;
            } else {
                answer += (i + 1 - oddPrefixNumber);
            }

            if (prefixSum % 2 == 1) {
                oddPrefixNumber++;
            }

            answer %= MOD;
        }

        return (int) answer;
    }
}
