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

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSum0(TreeNode root, int targetSum) {
        boolean[] findFlagP = new boolean[1];
        dfs(root, 0, targetSum, findFlagP);
        return findFlagP[0];
    }

    private void dfs(TreeNode cur, int sum, int targetSum, boolean[] findFlagP) {
        if (findFlagP[0]) {
            return;
        }
        if (cur != null) {
            sum += cur.val;
            if (targetSum == sum) {
                if (cur.left == null && cur.right == null) {
                    findFlagP[0] = true;
                    return;
                }
            }
            dfs(cur.left, sum, targetSum, findFlagP);
            dfs(cur.right, sum, targetSum, findFlagP);
        }
    }
}