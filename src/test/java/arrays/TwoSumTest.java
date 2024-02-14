package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TwoSumTest {

    TwoSum twoSum;

    public TwoSumTest() {
        twoSum = new TwoSum();
    }

    @Test
    void testTwoSum1() {
        int[] input = {2, 7, 11, 15};
        int target = 9;
        int[] output = twoSum.twoSum(input, target);

        Assertions.assertEquals(Arrays.toString(output), Arrays.toString(new int[]{0, 1}));
        System.out.println(Arrays.toString(output));
    }
}