package trie;

import org.junit.jupiter.api.Test;

class WordDictionaryTest {
    @Test
    void testWordDictionary1() {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search("dad"));
        System.out.println(wordDictionary.search("mad"));
        System.out.println(wordDictionary.search("sad"));

        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }

    @Test
    void testWordDictionary2() {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");

        System.out.println(wordDictionary.search("a")); // false
        System.out.println(wordDictionary.search(".at")); // false

        wordDictionary.addWord("bat");

        System.out.println(wordDictionary.search(".at")); // true
        System.out.println(wordDictionary.search("an.")); // true
        System.out.println(wordDictionary.search("a.d.")); // false
        System.out.println(wordDictionary.search("b.")); // false
        System.out.println(wordDictionary.search("a.d")); // true
        System.out.println(wordDictionary.search(".")); // false
    }
}