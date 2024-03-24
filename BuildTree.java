import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();// 构造哈希映射，帮助我们快速定位根节点
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n, inorder, 0, n, n, map);
    }

    private TreeNode buildTree(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2,
                               int n, Map<Integer, Integer> map) {
        if (s1 < 0 || s1 >= n || s2 < 0 || s2 >= n || e1 <= s1 || e2 <= s2) {
            return null;
        }
        int val = preorder[s1];
        TreeNode cur = new TreeNode(val);
        int i = map.get(val);
        if (s1 + 1 != e1) {
            cur.left = buildTree(preorder, s1 + 1, s1 + 1 + i - s2, inorder, s2, i, n, map);
            cur.right = buildTree(preorder, e1 - (e2 - i - 1), e1, inorder, i + 1, e2, n, map);
        }
        return cur;
    }

    public static void main(String[] args) {
        new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

    }
}
