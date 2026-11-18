package medium._2288_Apply_Discount_to_Prices;

import annotations.Medium;

@Medium
class Solution3 {

    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (isValidPrice(words[i])) {
                words[i] = applyDiscount(words[i], discount);
            }
        }

        return String.join(" ", words);
    }

    private boolean isValidPrice(String word) {
        if (word.length() < 2 || word.charAt(0) != '$') {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            if (!Character.isDigit(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private String applyDiscount(String word, int discount) {
        long price = Long.parseLong(word.substring(1));
        double discounted = price * (100 - discount) / 100.0;
        return String.format("$%.2f", discounted).replace(',', '.');
    }
}
