package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderNodeValues = new ArrayList<>();
        if (root == null) {
            return levelOrderNodeValues;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> currentLevelNodeValues = traverseCurrentLevel(queue);
            levelOrderNodeValues.add(currentLevelNodeValues);
        }
        return levelOrderNodeValues;
    }

    private List<Integer> traverseCurrentLevel(Queue<TreeNode> queue) {
        int levelNodesSize = queue.size();
        List<Integer> currentLevelNodeValues = new ArrayList<>();
        while (levelNodesSize > 0) {
            TreeNode treeNode = queue.poll();
            currentLevelNodeValues.add(treeNode.val);

            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }

            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
            levelNodesSize--;
        }
        return currentLevelNodeValues;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
