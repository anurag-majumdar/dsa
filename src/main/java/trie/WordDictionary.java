package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a Trie based search with dots.
 */
public class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node current = root;
        char[] ch = word.toCharArray();
        for (char c : ch) {
            current.children.putIfAbsent(c, new Node(c));
            current = current.children.get(c);
        }
        current.isCompleteWord = true;
    }

    public boolean search(String word) {
        Node current = root;
        return search(word, current);
    }

    private boolean search(String word, Node current) {
        int wordSize = word.length();
        int index = 0;
        while (index < wordSize) {
            char c = word.charAt(index);
            if (c == '.') {
                return searchDottedCharacter(word, current, index);
            }
            current = current.children.getOrDefault(c, null);
            if (current == null) {
                return false;
            }
            index++;
        }
        return current.isCompleteWord;
    }

    private boolean searchDottedCharacter(String word, Node current, int index) {
        for (Map.Entry<Character, Node> e : current.children.entrySet()) {
            current = e.getValue();
            if (search(word.substring(index + 1), current)) {
                return true;
            }
        }
        return false;
    }

    private static class Node {
        private char c;
        private Map<Character, Node> children = new HashMap<>();
        private boolean isCompleteWord;

        public Node() {
        }

        public Node(char c) {
            this.c = c;
        }
    }
}
