package arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TwoSumSortedTest {
    TwoSumSorted twoSumSorted;

    public TwoSumSortedTest() {
        twoSumSorted = new TwoSumSorted();
    }

    @Test
    void testTwoSumSorted1() {
        int[] input = {2, 7, 9, 12, 15};
        int[] output = twoSumSorted.twoSum(input, 9);

        System.out.println(Arrays.toString(output));
    }

    @Test
    void testTwoSumSorted2() {
        int[] input = {-2, -1, 0, 1, 3};
        int[] output = twoSumSorted.twoSum(input, 4);

        System.out.println(Arrays.toString(output));
    }
}