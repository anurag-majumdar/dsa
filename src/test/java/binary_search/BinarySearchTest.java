package binary_search;

import org.junit.jupiter.api.Test;

class BinarySearchTest {
    @Test
    void testBinarySearch() {
        BinarySearch binarySearch = new BinarySearch();

        int result = binarySearch.search(new int[]{
                -1, 0, 3, 5, 9, 12
        }, -1);

        System.out.println(result);
    }
}