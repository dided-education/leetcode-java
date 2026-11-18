package medium._2288_Apply_Discount_to_Prices;

import annotations.Medium;

@Medium
class Solution2 {

    public String discountPrices(String sentence, int discount) {
        sentence = ' ' + sentence + ' ';
        StringBuilder answer = new StringBuilder();

        StringBuilder currentPrice = new StringBuilder();
        boolean isPrice = false;

        for (int i = 1; i < sentence.length(); ++i) {
            char c = sentence.charAt(i);
            char previousC = sentence.charAt(i - 1);

            if (isPrice) {
                if (c == '.') {
                    if (Character.isDigit(previousC)) {
                        currentPrice.append(c);
                    } else {
                        answer.append(currentPrice);
                        answer.append(c);
                        isPrice = false;
                        currentPrice.setLength(0);
                    }
                } else if (Character.isDigit(c)) {
                    currentPrice.append(c);
                } else {
                    answer.append("$");
                    if (c == ' ') {
                        answer.append(priceWithDiscount(currentPrice.toString(), discount));
                    } else {
                        answer.append(currentPrice);
                    }
                    answer.append(c);
                    isPrice = false;
                    currentPrice.setLength(0);
                }
            } else {
                if (c == '$' && (previousC == ' ')) {
                    isPrice = true;
                } else {
                    answer.append(c);
                }
            }
        }

        answer.deleteCharAt(answer.length() - 1);
        return answer.toString();
    }

    private String priceWithDiscount(String priceString, int discount) {
        if (priceString.length() == 0) {
            return "";
        }
        double price = Double.parseDouble(priceString) * (100 - discount) / 100;

        return String.format("%.2f", price).replace(',', '.');
    }
}
