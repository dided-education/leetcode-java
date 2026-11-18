package medium._0043_Multiply_Strings;

import annotations.Medium;

@Medium
public class Solution {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n]; // the product has at most m + n digits

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;      // position for the carry
                int p2 = i + j + 1;  // position for the ones digit
                int sum = mul + res[p2];

                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int d : res) {
            if (!(sb.length() == 0 && d == 0)) { // skip leading zeros
                sb.append(d);
            }
        }

        return sb.toString();
    }
}