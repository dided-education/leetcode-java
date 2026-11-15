package easy._3364_Minimum_Positive_Sum_Subarray;

import annotations.Easy;

import java.util.List;

@Easy
public class Solution2 {

    public int minimumSumSubarray(List<Integer> nums, int minLength, int maxLength) {
        int minSum = Integer.MAX_VALUE;
        int n = nums.size();

        for (int length = minLength; length <= maxLength; length++) {
            int currentSum = 0;

            // Первое окно выбранной длины.
            for (int i = 0; i < length; i++) {
                currentSum += nums.get(i);
            }

            if (currentSum > 0) {
                minSum = Math.min(minSum, currentSum);
            }

            // Сдвигаем окно, сохраняя его длину.
            for (int rightIndex = length; rightIndex < n; rightIndex++) {
                currentSum += nums.get(rightIndex);
                currentSum -= nums.get(rightIndex - length);

                if (currentSum > 0) {
                    minSum = Math.min(minSum, currentSum);
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}