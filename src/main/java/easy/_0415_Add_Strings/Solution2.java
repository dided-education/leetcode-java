package easy._0415_Add_Strings;

import annotations.Easy;

@Easy
public class Solution2 {

    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return addStrings(num2, num1);
        }

        StringBuilder answer = new StringBuilder();
        int jump = 0;
        int current = 0;

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (j >= 0) {
            current = num1.charAt(i) + num2.charAt(j) - '0' - '0' + jump;
            if (current >= 10) {
                jump = current / 10;
                current = current % 10;
            } else {
                jump = 0;
            }

            answer.append(current);
            i--;
            j--;
        }

        while (i >= 0) {
            current = num1.charAt(i) - '0' + jump;
            if (current >= 10) {
                jump = current / 10;
                current = current % 10;
            } else {
                jump = 0;
            }

            answer.append(current);
            i--;
        }

        if (jump > 0) {
            answer.append(jump);
        }

        return answer.reverse().toString();
    }
}