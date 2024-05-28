package binary_search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchInsertTest {
    @Test
    void testSearchInsert() {
        SearchInsert searchInsert = new SearchInsert();

        int actualResult = searchInsert.searchInsert(new int[]{
                23, 35, 45, 67, 92
        }, 36);

        System.out.println(actualResult);
        Assertions.assertEquals(2, actualResult);
    }
}