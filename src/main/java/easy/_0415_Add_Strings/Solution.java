package easy._0415_Add_Strings;

import annotations.Easy;

@Easy
public class Solution {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int jump = 0;

        StringBuilder answer = new StringBuilder();

        while (i >= 0 || j >= 0 || jump > 0) {
            int sum = jump;

            if (i >= 0) {
                sum += num1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += num2.charAt(j) - '0';
                j--;
            }

            answer.append(sum % 10);
            jump = sum / 10;
        }

        return answer.reverse().toString();
    }
}