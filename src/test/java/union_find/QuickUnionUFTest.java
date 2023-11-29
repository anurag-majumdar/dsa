package union_find;

import org.junit.jupiter.api.Test;

class QuickUnionUFTest {
    @Test
    void testQuickUnion() {
        QuickUnionUF quickUnionUF = new QuickUnionUF(10);

        quickUnionUF.union(4, 3);
        quickUnionUF.union(3, 8);
        quickUnionUF.union(6, 5);
        quickUnionUF.union(9, 4);
        quickUnionUF.union(2, 1);

        System.out.println(quickUnionUF.getId());

        System.out.println("8 connected to 9 ? " + quickUnionUF.connected(8, 9));
        System.out.println("5 connected to 0 ? " + quickUnionUF.connected(5, 0));

        quickUnionUF.union(5, 0);
        System.out.println(quickUnionUF.getId());
        System.out.println("5 connected to 0 ? " + quickUnionUF.connected(5, 0));

        quickUnionUF.union(7, 2);
        quickUnionUF.union(6, 1);

        System.out.println(quickUnionUF.getId());
    }
}