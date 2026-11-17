package easy._2243_Calculate_Digit_Sum_of_a_String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, int k, String expected) {
        String actual = new Solution().digitSum(s, k);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("11111222223", 3, "135"),
                Arguments.of("00000000", 3, "000")
        );
    }
}