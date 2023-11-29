package union_find;

import org.junit.jupiter.api.Test;

class WeightedQuickUnionUFTest {
    @Test
    void testWeightedQuickUnion() {
        WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(10);

        weightedQuickUnionUF.union(4, 3);
        weightedQuickUnionUF.union(3, 8);
        weightedQuickUnionUF.union(6, 5);
        weightedQuickUnionUF.union(9, 4);
        weightedQuickUnionUF.union(2, 1);

        System.out.println(weightedQuickUnionUF.getId());

        System.out.println("8 connected to 9 ? " + weightedQuickUnionUF.connected(8, 9));
        System.out.println("5 connected to 0 ? " + weightedQuickUnionUF.connected(5, 0));

        weightedQuickUnionUF.union(5, 0);
        System.out.println(weightedQuickUnionUF.getId());
        System.out.println("5 connected to 0 ? " + weightedQuickUnionUF.connected(5, 0));

        weightedQuickUnionUF.union(7, 2);
        weightedQuickUnionUF.union(6, 1);

        System.out.println(weightedQuickUnionUF.getId());
    }
}