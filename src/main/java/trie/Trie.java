package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Trie Data Structure with insert, search, startsWith methods.
 */
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

    /**
     * Partially working.
     *
     * @param prefix the search prefix
     * @return the list of words matching the search prefix.
     */
    public List<String> searchWithPrefix(String prefix) {
        List<String> searchResults = new ArrayList<>();
        Node current = root;
        char[] prefixChars = prefix.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char prefixChar : prefixChars) {
            sb.append(prefixChar);
            current = current.children.getOrDefault(prefixChar, null);
            if (current == null) {
                return searchResults;
            }

            if (current.isCompleteWord) {
                searchResults.add(sb.toString());
            }
        }

        getRemainingSearchResults(prefix, current, searchResults);
        return searchResults;
    }

    private void getRemainingSearchResults(String prefix, Node current, List<String> searchResults) {
        for (Map.Entry<Character, Node> entry : current.children.entrySet()) {
            current = entry.getValue();
            if (current == null) {
                return;
            }
            if (current.isCompleteWord) {
                searchResults.add(prefix + current.c);
            }
            getRemainingSearchResults(prefix + current.c, current, searchResults);
        }
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
