import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (isIdentical(node, subRoot)) return true;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return false;
    }

    private boolean isIdentical(TreeNode node1, TreeNode node2) {
        if (node1 == node2) return true;
        if (node1 == null || node2 == null) return false;
        return node1.val == node2.val && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
    }

    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        TreeNode(Integer[] nodes) {
            if (nodes == null || nodes.length == 0) {
                return;
            }
            int n = nodes.length;
            this.val = nodes[0];
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(this);
            int index = 1;
            while (index < n) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize && index < n; i++) {
                    TreeNode node = queue.poll();
                    Integer leftVal = nodes[index++];
                    if (leftVal != null) {
                        node.left = new TreeNode(leftVal);
                        queue.offer(node.left);
                    }
                    if (index == n) {
                        break;
                    }
                    Integer rightVal = nodes[index++];
                    if (rightVal != null) {
                        node.right = new TreeNode(rightVal);
                        queue.offer(node.right);
                    }
                }
            }
        }

        @Override
        public String toString() {
            List<Integer> treeNodeStrList = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> preLevelList = new ArrayList<>();
            queue.offer(this);
            preLevelList.add(this.val);
            while(!queue.isEmpty()) {
                if (!preLevelList.isEmpty()) {
                    treeNodeStrList.addAll(preLevelList);
                    preLevelList.clear();
                }
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode current = queue.poll();
                    if (current.left != null) {
                        queue.offer(current.left);
                        preLevelList.add(current.left.val);
                    } else {
                        preLevelList.add(null);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                        preLevelList.add(current.right.val);
                    } else {
                        preLevelList.add(null);
                    }
                }
            }
            return treeNodeStrList.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Integer[] nodes1 = {3,4,5,1,2};
        Integer[] nodes2 = {4,1,2};
        System.out.println("test: " + sol.isSubtree(new TreeNode(nodes1), new TreeNode(nodes2)));
    }
}