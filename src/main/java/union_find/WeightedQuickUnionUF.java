package union_find;

import java.util.Arrays;

/**
 * Implements a quick find union-find algorithm with an array of id integers.
 * M union-find operations on a set of N objects => O(N + M log N)
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;

    /**
     * Generate the array of id integers.
     * Internally will be represented as a tree.
     * O(n) time complexity.
     *
     * @param size the total size of the id array of integers.
     */
    public WeightedQuickUnionUF(int size) {
        id = new int[size];
        sz = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int u = root(p);
        int v = root(q);
        if (u == v) return;
        if (sz[u] < sz[v]) {
            id[u] = v;
            sz[v] += sz[u];
        } else {
            id[v] = u;
            sz[u] += sz[v];
        }
    }

    public String getId() {
        return Arrays.toString(id);
    }
}
