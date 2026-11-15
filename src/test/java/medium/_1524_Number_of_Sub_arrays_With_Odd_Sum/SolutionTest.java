package medium._1524_Number_of_Sub_arrays_With_Odd_Sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] arr, int expected) {
        int actual = new Solution().numOfSubarrays(arr);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5}, 4),
                Arguments.of(new int[]{2, 4, 6}, 0),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 16)
        );
    }
}