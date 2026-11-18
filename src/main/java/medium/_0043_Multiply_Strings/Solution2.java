package medium._0043_Multiply_Strings;

import annotations.Medium;

@Medium
public class Solution2 {

    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }

        String previous = "0";
        for (int i = num2.length() - 1; i >= 0; --i) {
            char digit = num2.charAt(i);

            if (digit == '0') continue;

            int zeroCount = num2.length() - i - 1;
            String current = iteration(num1, digit, zeroCount);
            previous = addStrings(current, previous);
        }

        return previous;
    }

    private String iteration(String num, char charDigit, int zeroCount) {
        int digit = charDigit - '0';
        int jump = 0;
        StringBuilder answer = new StringBuilder();

        answer.repeat("0", Math.max(0, zeroCount));

        int i = num.length() - 1;

        while (i >= 0 || jump > 0) {
            int sum = jump;

            if (i >= 0) {
                sum += (num.charAt(i) - '0') * digit;
                i--;
            }

            answer.append(sum % 10);
            jump = sum / 10;
        }
        return answer.reverse().toString();
    }

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