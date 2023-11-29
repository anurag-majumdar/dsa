package minimum_spanning_tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinCostConnectPointsTest {
    MinCostConnectPoints minCostConnectPoints;

    public MinCostConnectPointsTest() {
        minCostConnectPoints = new MinCostConnectPoints();
    }

    @Test
    void testMinCostConnectPoints1() {
        int[][] points = new int[][]{
                {-1000000, -1000000}, {1000000, 1000000}
        };

        int expectedResult = 4000000;
        int actualResult = minCostConnectPoints.minCostConnectPoints(points);
        System.out.println(actualResult);
        Assertions.assertEquals(4000000, actualResult);
    }

    @Test
    void testMinCostConnectPoints2() {
        int[][] points = new int[][]{
                {0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}
        };

        int expectedResult = 20;
        int actualResult = minCostConnectPoints.minCostConnectPoints(points);
        System.out.println(actualResult);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}