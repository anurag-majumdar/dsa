package trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private final Node root = new Node();

    public void insert(String word) {
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
