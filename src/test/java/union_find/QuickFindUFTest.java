package union_find;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QuickFindUFTest {
    @Test
    void testQuickFind() {
        QuickFindUF quickFindUF = new QuickFindUF(10);

        quickFindUF.union(4, 3);
        quickFindUF.union(3, 8);
        quickFindUF.union(6, 5);
        quickFindUF.union(9, 4);
        quickFindUF.union(2, 1);

        System.out.println(quickFindUF.getId());

        System.out.println("8 connected to 9 ? " + quickFindUF.connected(8, 9));
        System.out.println("5 connected to 0 ? " + quickFindUF.connected(5, 0));

        quickFindUF.union(5, 0);
        System.out.println(quickFindUF.getId());
        System.out.println("5 connected to 0 ? " + quickFindUF.connected(5, 0));

        quickFindUF.union(7, 2);
        quickFindUF.union(6, 1);

        System.out.println(quickFindUF.getId());
    }
}
