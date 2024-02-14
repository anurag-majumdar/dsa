package arrays;

/**
 * 167. Two Sum II - Input Array Is Sorted
 */
public class TwoSumSorted {
    /**
     * O (n) time & O(1) space
     *
     * @param numbers input collection
     * @param target  the target sum it should match
     * @return the 2 indices of the collection which sum up to the target.
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            if (currentSum == target) {
                return new int[]{left, right};
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}
