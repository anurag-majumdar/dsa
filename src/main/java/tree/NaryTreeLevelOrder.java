package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelOrderNodeValues = new ArrayList<>();
        if (root == null) {
            return levelOrderNodeValues;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> currentLevelNodeValues = traverseCurrentLevel(queue);
            levelOrderNodeValues.add(currentLevelNodeValues);
        }
        return levelOrderNodeValues;
    }

    private List<Integer> traverseCurrentLevel(Queue<Node> queue) {
        int levelNodesSize = queue.size();
        List<Integer> currentLevelNodeValues = new ArrayList<>();
        while (levelNodesSize > 0) {
            Node node = queue.poll();
            currentLevelNodeValues.add(node.val);
            queue.addAll(node.children);
            levelNodesSize--;
        }
        return currentLevelNodeValues;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
