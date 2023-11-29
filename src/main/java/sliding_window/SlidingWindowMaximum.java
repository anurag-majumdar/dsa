package sliding_window;

import java.util.*;

public class SlidingWindowMaximum {

    // Sanity test
    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        List<Integer> nums = Arrays.asList(4, 1, 3, 5, 1, 2, 3, 2, 1, 1, 5);
        int k = 3;
        // resultList = [5, 5, 3, 3, 3, 2, 5]

        List<Integer> resultListIteration = slidingWindowMaximum.findSlidingWindowMaximumIteration(nums, nums.size(), k);
        List<Integer> resultListQueue = slidingWindowMaximum.findSlidingWindowMaximumQueue(nums, nums.size(), k);

        System.out.println(resultListIteration);
        System.out.println(resultListQueue);
    }

    /**
     * Using Iteration, naive solution.
     * O((n-k) * k) => O(n * k)
     * O(1)
     *
     * @param nums contains the elements of the list
     * @param n    contains the total size of the list
     * @param k    contains the size of the sliding window
     * @return maximum sliding window list
     */
    List<Integer> findSlidingWindowMaximumIteration(List<Integer> nums, int n, int k) {
        List<Integer> resultList = new ArrayList<>();

        int i = 0;
        // O (n - k)
        while (i <= (n - k)) {
            int maxElement = findMax(nums.subList(i, i + k)); // O(k)
            resultList.add(maxElement); // O(k)
            i++;
        }

        return resultList;
    }

    // O(k)
    private int findMax(List<Integer> subList) {
        int max = Integer.MIN_VALUE;
        for (int num : subList) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Using Priority Queue.
     * O((n-k) * log k) => O(n * log k)
     * O(k)
     *
     * @param nums contains the elements of the list
     * @param n    contains the total size of the list
     * @param k    contains the size of the sliding window
     * @return maximum sliding window list
     */
    List<Integer> findSlidingWindowMaximumQueue(List<Integer> nums, int n, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> resultList = new ArrayList<>();

        int i = 0;
        while (i < k) {
            priorityQueue.add(nums.get(i++)); // O(log k)
        }
        resultList.add(priorityQueue.peek()); // O(log k)
        priorityQueue.remove(nums.get(0)); // O(log k)

        // O(n)
        while (i < n) {
            priorityQueue.remove(nums.get(i - k)); // O(log k)
            priorityQueue.add(nums.get(i)); // O(log k)
            resultList.add(priorityQueue.peek()); // O(log k)
            i++;
        }

        return resultList;
    }

    /**
     * Best Solution using Deque.
     * O(n - k) => O(n)
     * O(k)
     *
     * @param nums contains the elements of the list
     * @param n    contains the total size of the list
     * @param k    contains the size of the sliding window
     * @return maximum sliding window list
     */
    List<Integer> findSlidingWindowMaximumDeque(List<Integer> nums, int n, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> resultList = new ArrayList<>();

        int i = 0;
        while (i < k) {
            while (!deque.isEmpty() && nums.get(i) > nums.get(deque.peekLast())) {
                deque.removeLast(); // O(1)
            }
            deque.addLast(i); // O(1)
            i++;
        }

        // O(n)
        while (i < n) {
            resultList.add(nums.get(deque.peek())); // O(1)

            while (!deque.isEmpty() && deque.peek() <= (i - k)) {
                deque.removeFirst(); // O(1)
            }

            while (!deque.isEmpty() && nums.get(i) > nums.get(deque.peekLast())) {
                deque.removeLast(); // O(1)
            }
            deque.addLast(i); // O(1)
            i++;
        }

        return resultList;
    }
}
