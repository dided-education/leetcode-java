package medium._2914_Minimum_Number_of_Changes_to_Make_Binary_String_Beautiful;

import annotations.Medium;

@Medium
public class Solution {

    public int minChanges(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i += 2) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);

            if (first != second) {
                answer++;
            }
        }

        return answer;
    }
}