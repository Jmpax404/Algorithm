public class Solution {

    private void dfs(TreeNode root) {
        if (root != null) {
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            dfs(root.left);
            dfs(root.right);
        }
    }


    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
}