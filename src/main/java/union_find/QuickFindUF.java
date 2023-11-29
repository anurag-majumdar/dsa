package union_find;

import java.util.Arrays;

/**
 * Implements a quick find union-find algorithm with an array of id integers.
 * M union-find operations on a set of N objects => O(M * N)
 */
public class QuickFindUF {
    private int[] id;

    /**
     * Generate the array of id integers.
     * O(n) time complexity.
     *
     * @param size the total size of the id array of integers.
     */
    public QuickFindUF(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * Check if two nodes are connected or not.
     * O(1) time complexity.
     *
     * @param p node 1 as integer
     * @param q node 2 as integer
     * @return true/false if nodes are connected to each other.
     */
    public boolean connected(int p, int q) {
        if (id[p] == id[q]) {
            return true;
        }
        return false;
    }

    /**
     * Unite two sets of nodes or connected nodes.
     * O(n) time complexity.
     *
     * @param p node 1 as integer
     * @param q node 2 as integer
     */
    public void union(int p, int q) {
        if (connected(p, q)) {
            return;
        }
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    /**
     * Get the array of integer ids as a string.
     *
     * @return String of id integers.
     */
    public String getId() {
        return Arrays.toString(id);
    }
}
