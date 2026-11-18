package medium._2914_Minimum_Number_of_Changes_to_Make_Binary_String_Beautiful;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, int expected) {
        int actual = new Solution().minChanges(s);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("1001", 2),
                Arguments.of("10", 1),
                Arguments.of("0000", 0)
        );
    }
}