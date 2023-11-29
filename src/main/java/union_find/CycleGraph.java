package union_find;

public class CycleGraph {

    /**
     * Time complexity: O(e * (v + 1)) => O(e * v)
     * Space complexity: O(v + 1)
     *
     * @param vertices of the graph as integer
     * @param edges    of the graph as array of arrays
     * @return the pair of redundant connection
     */
    public int[] findRedundantConnection(int vertices, int[][] edges) {
        // O(v + 1)
        QuickFindUF quickFindUF = new QuickFindUF(vertices + 1);

        // O(e * (v + 1)) => O(e * v)
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            // O(1)
            if (quickFindUF.connected(edge[0], edge[1])) {
                return edge;
            }
            // O(v + 1)
            quickFindUF.union(edge[0], edge[1]);
        }
        return new int[]{};
    }

    /**
     * Time complexity: O(e * (v + 1)) => O(e * v)
     * Space complexity: O(v + 1)
     *
     * @param vertices of the graph as integer
     * @param edges    of the graph as array of arrays
     * @return if graph has a cycle
     */
    public boolean detectCycleInGraph(int vertices, int[][] edges) {
        // O(v + 1)
        QuickFindUF quickFindUF = new QuickFindUF(vertices + 1);

        // O(e * (v + 1)) => O(e * v)
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            // O(1)
            if (quickFindUF.connected(edge[0], edge[1])) {
                return true;
            }
            // O(v + 1)
            quickFindUF.union(edge[0], edge[1]);
        }
        return false;
    }
}
