package trie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrieTest {
    @Test
    void testLongestCommonPrefix1() {
        Trie trie = new Trie();

        trie.insert("flower");
        trie.insert("flow");
        trie.insert("flight");

        Assertions.assertEquals("fl", trie.getLongestCommonPrefix());
    }

    @Test
    void testLongestCommonPrefix2() {
        Trie trie = new Trie();

        trie.insert("dog");
        trie.insert("racecar");
        trie.insert("car");

        Assertions.assertEquals("", trie.getLongestCommonPrefix());
    }
}
