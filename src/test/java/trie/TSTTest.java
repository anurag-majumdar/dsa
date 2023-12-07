package trie;

import org.junit.jupiter.api.Test;

class TSTTest {
    @Test
    void testTst() {
        TST<Integer> tst = new TST<>();

        tst.put("flower", 5);
        tst.put("flow", 10);
        tst.put("flight", 10);

        System.out.println(tst.contains("flow"));
    }
}