public class Solution {

    /*
    对于任意二叉树，都可以通过广度优先搜索或深度优先搜索计算节点个数，时间复杂度和空间复杂度都是 O(n)
    */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLevels = countLevels(root.left);
        int rightLevels = countLevels(root.right);
        if (leftLevels == rightLevels) {
            return countNodes(root.right) + (1 << leftLevels);
        } else {
            return countNodes(root.left) + (1 << rightLevels);
        }
    }

    private int countLevels(TreeNode root) {
        int levels = 0;
        while (root != null) {
            levels++;
            root = root.left;
        }
        return levels;
    }
}


class Solution2 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode node = root;
        int level = 0;// 除最后一层外有多少层
        while (node.left != null) {
            level++;
            node = node.left;
        }
        // 二分
        int low = 1 << level;
        int high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;// = (high + low) /2 = (high+low) >>>2
            if (nonExist(root, level, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (nonExist(root, level, high)) {
            return high - 1;//第一个不存在的前面就是存在
        } else {
            return high;//最后一个也不是不存在，那就是都存在，返回high
        }
    }

    private boolean nonExist(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);

        TreeNode node = root;

        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>>= 1;
        }
        return node == null;//这个时候bits都等于0了

    }

}