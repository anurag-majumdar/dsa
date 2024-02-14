package arrays;

/**
 * 167. Two Sum II - Input Array Is Sorted
 */
public class TwoSumSorted {
    /**
     * Two Pointer approach
     * O (n) time & O(1) space
     *
     * @param numbers input collection
     * @param target  the target sum it should match
     * @return the 2 indices of the collection which sum up to the target.
     */
    public int[] twoSumTwoPointer(int[] numbers, int target) {
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

    /**
     * Binary Search approach
     * O (n ^ 2) time & O(1) space
     *
     * @param numbers input collection
     * @param target  the target sum it should match
     * @return the 2 indices of the collection which sum up to the target.
     */
    public int[] twoSumBinarySearch(int[] numbers, int target) {
        int index;
        for (index = 0; index < numbers.length; index++) {
            int compliment = target - numbers[index];
            int[] result = binarySearchCompliment(numbers, index, compliment);
            if (result != null) return result;
        }
        return new int[]{};
    }

    private int[] binarySearchCompliment(int[] numbers, int index, int compliment) {
        int left = index + 1;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (numbers[mid] == compliment) {
                return new int[]{index, mid};
            } else if (numbers[mid] < compliment) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
