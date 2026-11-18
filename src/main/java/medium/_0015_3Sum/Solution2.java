package medium._0015_3Sum;

import annotations.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Medium
public class Solution2 {

    public List<List<Integer>> threeSum(int[] nums) {
        int diff = 100000;
        int[] freq = new int[200001];
        Set<Integer> set = new TreeSet<>();

        for (int num : nums) {
            freq[num + diff]++;
            if (freq[num + diff] == 1) {
                set.add(num);
            }
        }

        int[] sortedArray = set.stream().mapToInt(s -> s).toArray();

        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < sortedArray.length; ++i) {
            int num1 = sortedArray[i];
            freq[num1 + diff]--;
            for (int j = i; j < sortedArray.length; j++) {
                int num2 = sortedArray[j];
                if (freq[num2 + diff] == 0) continue;
                freq[num2 + diff]--;

                int num3 = 0 - num1 - num2;

                // num3 need to be more than num2 to avoid duplicate
                if (num3 >= num2 && num3 + diff < freq.length && freq[num3 + diff] > 0) {
                    answer.add(List.of(num1, num2, num3));
                }
                freq[num2 + diff]++;
            }
            freq[num1 + diff]++;
        }

        return answer;
    }
}