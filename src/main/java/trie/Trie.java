package trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private final Node root = new Node();

    public void insert(String word) {
        Node current = root;
        // O (w)
        char[] ch = word.toCharArray();
        for (char c : ch) {
            current.children.putIfAbsent(c, new Node(c)); // O(1)
            current = current.children.get(c); // O(1)
        }
        current.isCompleteWord = true;
    }

    public boolean search(String word) {
        Node current = root;
        // O (w)
        char[] ch = word.toCharArray();
        for (char c : ch) {
            current = current.children.getOrDefault(c, null);
            if (current == null) {
                return false;
            }
        }
        return current.isCompleteWord;
    }

    public boolean startsWith(String prefix) {
        Node current = root;
        // O (w)
        char[] ch = prefix.toCharArray();
        for (char c : ch) {
            current = current.children.getOrDefault(c, null);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    public String getLongestCommonPrefix() {
        StringBuilder sb = new StringBuilder();
        Node current = root;
        // O (w) where w is the shortest word
        while (!current.isCompleteWord) {
            if (current.children.size() != 1) return sb.toString();
            for (Map.Entry<Character, Node> e : current.children.entrySet()) {
                sb.append(e.getKey());
                current = e.getValue();
            }
        }
        return sb.toString();
    }

    private static class Node {
        char c;
        boolean isCompleteWord;
        Map<Character, Node> children = new HashMap<>();

        public Node() {
        }

        public Node(char c) {
            this.c = c;
        }
    }
}
