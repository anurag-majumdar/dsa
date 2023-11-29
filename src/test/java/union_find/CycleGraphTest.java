package union_find;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CycleGraphTest {

    CycleGraph cg;

    public CycleGraphTest() {
        cg = new CycleGraph();
    }

    @Test
    void testRc1() {
        int vertices = 3;
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};

        System.out.println("Cycle in graph? " + cg.detectCycleInGraph(vertices, edges));
        System.out.println(Arrays.toString(cg.findRedundantConnection(vertices, edges)));
    }

    @Test
    void testRc2() {
        int vertices = 6;
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {3, 6}, {4, 5}, {1, 5}};

        System.out.println("Cycle in graph? " + cg.detectCycleInGraph(vertices, edges));
        System.out.println(Arrays.toString(cg.findRedundantConnection(vertices, edges)));
    }

    @Test
    void testRc3() {
        int vertices = 6;
        int[][] edges = new int[][]{{1, 4}, {2, 5}, {3, 6}};

        System.out.println("Cycle in graph? " + cg.detectCycleInGraph(vertices, edges));
        System.out.println(Arrays.toString(cg.findRedundantConnection(vertices, edges)));
    }
}
