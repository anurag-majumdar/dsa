package trie;

public class RTrie {
    private static final int R = 256;
    private Node root = new Node();

    public boolean contains(String key) {
        return get(key);
    }

    private boolean get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return false;
        }
        return x.isCompleteWord;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            return x;
        }
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, boolean isCompleteWord) {
        root = put(root, key, isCompleteWord, 0);
    }

    private Node put(Node x, String key, boolean isCompleteWord, int d) {
        if (x == null) {
            x = new Node();
        }
        if (d == key.length()) {
            x.isCompleteWord = isCompleteWord;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, isCompleteWord, d + 1);
        return x;
    }

    private static class Node {
        private final Node[] next = new Node[R];
        private boolean isCompleteWord;
    }
}
