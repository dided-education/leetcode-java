package easy._2243_Calculate_Digit_Sum_of_a_String;

import annotations.Easy;

@Easy
public class Solution {

    public String digitSum(String s, int k) {
        int n = s.length();
        if (n <= k) return s;

        StringBuilder newS = new StringBuilder();
        int sum = 0;

        for (int i = 0; i < n; ++i) {
            sum += s.charAt(i) - '0';
            if ((i + 1) % k == 0) {
                newS.append(sum);
                sum = 0;
            }
        }

        if (n % k != 0) {
            newS.append(sum);
        }

        return digitSum(newS.toString(), k);
    }
}