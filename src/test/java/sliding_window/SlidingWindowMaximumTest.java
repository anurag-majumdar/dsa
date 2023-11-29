package sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SlidingWindowMaximumTest {
    SlidingWindowMaximum slidingWindowMaximum;

    SlidingWindowMaximumTest() {
        slidingWindowMaximum = new SlidingWindowMaximum();
    }

    @Test
    void testFindSlidingWindowMaximumIteration() {
        List<Integer> inputList = Arrays.asList(4, 1, 3, 5, 1, 2, 3, 2, 1, 1, 5);
        List<Integer> outputList = Arrays.asList(4, 5, 5, 5, 3, 3, 3, 2, 5);
        int k = 3;

        List<Integer> resultList = slidingWindowMaximum.findSlidingWindowMaximumIteration(inputList, inputList.size(), k);
        System.out.println(resultList);

        Assertions.assertEquals(outputList, resultList);
    }

    @Test
    void testFindSlidingWindowMaximumQueue() {
        List<Integer> inputList = Arrays.asList(4, 1, 3, 5, 1, 2, 3, 2, 1, 1, 5);
        List<Integer> outputList = Arrays.asList(4, 5, 5, 5, 3, 3, 3, 2, 5);

        int k = 3;

        List<Integer> resultList = slidingWindowMaximum.findSlidingWindowMaximumQueue(inputList, inputList.size(), k);
        System.out.println(resultList);

        Assertions.assertEquals(outputList, resultList);
    }

    @Test
    void testFindSlidingWindowMaximumDeque() {
        List<Integer> inputList = Arrays.asList(4, 1, 3, 5, 1, 2, 3, 2, 1, 1, 5);
        List<Integer> outputList = Arrays.asList(4, 5, 5, 5, 3, 3, 3, 2, 5);

        int k = 3;

        List<Integer> resultList = slidingWindowMaximum.findSlidingWindowMaximumDeque(inputList, inputList.size(), k);
        System.out.println(resultList);

        Assertions.assertEquals(outputList, resultList);
    }
}
