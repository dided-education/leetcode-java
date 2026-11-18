package medium._2288_Apply_Discount_to_Prices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String sentence, int discount, String expected) {
        String actual = new Solution().discountPrices(sentence, discount);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        "there are $1 $2 and 5$ candies in the shop",
                        50,
                        "there are $0.50 $1.00 and 5$ candies in the shop"),
                Arguments.of(
                        "1 2 $3 4 $5 $6 7 8$ $9 $10$",
                        100,
                        "1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$"),
                Arguments.of(
                        "price is $1 and $23",
                        95,
                        "price is $0.05 and $1.15")
        );
    }
}
