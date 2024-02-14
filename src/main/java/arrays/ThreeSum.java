package arrays;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        // O (n * log n)
        Arrays.sort(nums);

        // O (n ^ 2)
        int index;
        for (index = 0; index < nums.length - 2; index++) {
            int currentNum = nums[index];
            int left = index + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = currentNum + nums[left] + nums[right];
                if (currentSum == 0) {
                    result.add(Arrays.asList(currentNum, nums[left], nums[right]));
                    left++;
                    right--;
                } else if (currentSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
