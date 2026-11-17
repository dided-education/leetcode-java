package easy._2243_Calculate_Digit_Sum_of_a_String;

import annotations.Easy;

@Easy
public class Solution2 {

    public String digitSum(String s, int k) {

        int n = s.length();
        while (n > k) {
            StringBuilder newS = new StringBuilder();

            int i = 0;
            while (i < n) {
                String round = s.substring(i, Math.min(i + k, n));
                int kRoundSum = 0;

                for (char ch: round.toCharArray()) {
                    kRoundSum += (ch - '0');
                }

                newS.append(kRoundSum);
                i += k;
            }

            s = newS.toString();
            n = s.length();
        }

        return s;
    }
}