package medium._2288_Apply_Discount_to_Prices;

import annotations.Medium;

@Medium
class Solution {

    public String discountPrices(String sentence, int discount) {
        sentence = ' ' + sentence + ' ';
        int n = sentence.length();
        StringBuilder answer = new StringBuilder(n);

        for (int i = 1; i < n; i++) {
            char c = sentence.charAt(i);

            if (c == '$' && sentence.charAt(i - 1) == ' ') {
                int j = i + 1;
                long price = 0;
                while (j < n && Character.isDigit(sentence.charAt(j))) {
                    price = price * 10 + (sentence.charAt(j) - '0');
                    j++;
                }

                boolean hasDigits = j > i + 1;

                if (hasDigits && sentence.charAt(j) == ' ') {
                    answer.append(formatPrice(price, discount));
                    i = j - 1;
                    continue;
                }
            }

            answer.append(c);
        }

        answer.deleteCharAt(answer.length() - 1);
        return answer.toString();
    }

    private String formatPrice(long price, int discount) {
        double discounted = price * (100 - discount) / 100.0;
        return String.format("$%.2f", discounted).replace(',', '.');
    }
}
