package trie;

import java.util.HashMap;
import java.util.Map;

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
                for (Map.Entry<Character, Node> e : current.children.entrySet()) {
                    current = e.getValue();
                    return search(word.substring(index + 1), current);
                }
            }
            current = current.children.getOrDefault(c, null);
            if (current == null) {
                return false;
            }
            index++;
        }
        return current.isCompleteWord;
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
