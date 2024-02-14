package arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ThreeSumTest {
    ThreeSum threeSum;

    public ThreeSumTest() {
        threeSum = new ThreeSum();
    }

    @Test
    void testThreeSum1() {
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> output = threeSum.threeSum(input);
        System.out.println(output);
    }

    @Test
    void testThreeSum2() {
        int[] input = {-2, 0, 1, 1, 2};
        List<List<Integer>> output = threeSum.threeSum(input);
        System.out.println(output);
    }

    @Test
    void testThreeSum3() {
        int[] input = {12, 3, 1, 2, -6, 5, -8, 6};
        List<List<Integer>> output = threeSum.threeSum(input);
        System.out.println(output);
    }
}
