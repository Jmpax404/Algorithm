import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (!queueOffer(root.left, root.right, queue)) {
            return false;
        }
        while (queue.size() >= 2) {
            TreeNode a = queue.poll();
            TreeNode b = queue.poll();
            if (a.val != b.val) {
                return false;
            }
            if (!queueOffer(a.left, b.right, queue)) {
                return false;
            }
            if (!queueOffer(a.right, b.left, queue)) {
                return false;
            }
        }
        return true;
    }

    private boolean queueOffer(TreeNode a, TreeNode b, Queue<TreeNode> queue) {
        if (a == null && b == null) {
            return true;
        } else if (a != null && b != null) {
            queue.offer(a);
            queue.offer(b);
            return true;
        } else {
            return false;
        }
    }

}

class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        return nodeEquals(root.left, root.right);
    }

    private boolean nodeEquals(TreeNode a, TreeNode b) {
        return a == null ? (b == null) : (b != null && a.val == b.val && nodeEquals(a.left, b.right) && nodeEquals(a.right, b.left));
    }
}

class Solution2 {//没用的加密

    public boolean isSymmetric(TreeNode root) {
        return new BiPredicate<TreeNode, TreeNode>() {
            @Override
            public boolean test(TreeNode a, TreeNode b) {
                return a == null ? (b == null) : (b != null && a.val == b.val && test(a.left, b.right) && test(a.right, b.left));
            }
        }.test(root.left, root.right);
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
