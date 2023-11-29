package minimum_spanning_tree;

import union_find.WeightedQuickUnionPathCompressionUF;

import java.util.*;

public class MinCostConnectPoints {

    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = constructEdgesFromPoints(points);
        Queue<Edge> mst = constructMst(edges, points.length);
        return calculateMstWeightSum(mst);
    }

    private void printEdges(List<Edge> edges) {
        for (Edge edge : edges) {
            System.out.println(edge.toString());
        }
    }

    private List<Edge> constructEdgesFromPoints(int[][] points) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            int[] edgeI = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] edgeJ = points[j];
                int distance = Math.abs(edgeJ[0] - edgeI[0]) + Math.abs(edgeJ[1] - edgeI[1]);
                Edge edge = new Edge(i, j, distance);
                edges.add(edge);
            }
        }
        return edges;
    }

    private Queue<Edge> constructMst(List<Edge> edges, int totalVertices) {
        Queue<Edge> mst = new LinkedList<>();

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(Edge::getDistance));
        pq.addAll(edges);

        WeightedQuickUnionPathCompressionUF uf = new WeightedQuickUnionPathCompressionUF(totalVertices);
        while (!pq.isEmpty() && mst.size() < totalVertices - 1) {
            Edge e = pq.poll();
            int v = e.x;
            int w = e.y;
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                mst.add(e);
            }
        }
        return mst;
    }

    private int calculateMstWeightSum(Queue<Edge> mst) {
        int mstWeightSum = 0;
        for (Edge e : mst) {
            mstWeightSum += e.distance;
        }
        return mstWeightSum;
    }

    static class Edge {
        private int x;
        private int y;
        private int distance;

        public Edge(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "x=" + x +
                    ", y=" + y +
                    ", distance=" + distance +
                    '}';
        }
    }
}
