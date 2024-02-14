package arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> hasSeen = new HashMap<>();
        int index;
        for (index = 0; index < nums.length; index++) {
            int num = nums[index];
            if (hasSeen.getOrDefault((target - num), null) != null) {
                result[0] = hasSeen.get(target - num);
                result[1] = index;
                return result;
            } else {
                hasSeen.put(num, index);
            }
        }
        return result;
    }
}
