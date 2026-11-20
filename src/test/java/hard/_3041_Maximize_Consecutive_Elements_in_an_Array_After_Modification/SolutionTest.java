package hard._3041_Maximize_Consecutive_Elements_in_an_Array_After_Modification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, int expected) {
        int actual = new Solution().maxSelectedElements(nums);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{2, 1, 5, 1, 1}, 3),
                Arguments.of(new int[]{1, 4, 7, 10}, 1)
        );
    }
}
