package union_find;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RedundantConnectionTest {
    RedundantConnection rc;

    public RedundantConnectionTest() {
        rc = new RedundantConnection();
    }

    @Test
    void testRc1() {
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};

        System.out.println("Redundant connection: " + Arrays.toString(rc.findRedundantConnection(edges)));
    }

    @Test
    void testRc2() {
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {3, 6}, {4, 5}, {1, 5}};

        System.out.println("Redundant connection: " + Arrays.toString(rc.findRedundantConnection(edges)));
    }
}
