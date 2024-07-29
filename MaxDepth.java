public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

class Solution0 {
    private int depth;
    private int maxDepth;

    public int maxDepth(TreeNode root) {
        depth = 0;
        maxDepth = 0;
        traverse(root);
        return maxDepth;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}

class TreeNode {
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