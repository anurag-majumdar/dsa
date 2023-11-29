package union_find;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        QuickFindUF quickFindUF = new QuickFindUF(edges.length + 1);

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (quickFindUF.connected(edge[0], edge[1])) {
                return edge;
            }
            quickFindUF.union(edge[0], edge[1]);
        }
        return new int[]{};
    }
}
