package easy._0415_Add_Strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String num1, String num2, String expected) {
        String actual = new Solution().addStrings(num1, num2);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("11", "123", "134"),
                Arguments.of("456", "77", "533"),
                Arguments.of("0", "0", "0")
        );
    }
}