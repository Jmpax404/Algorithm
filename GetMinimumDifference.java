import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int min = Integer.MAX_VALUE;
    private int preVal = -100000;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode cur) {
        if (cur != null) {
            dfs(cur.left);
            int t = cur.val - preVal;
            if (t < min) {
                min = t;
            }
            preVal = cur.val;
            dfs(cur.right);
        }
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
