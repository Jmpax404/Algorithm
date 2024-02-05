import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        long sum = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            //一次性全部取出表示一层。何时结束通过队列大小确定。
            for (int i = 0, len = queue.size(); i < len; i++) {
                TreeNode current = queue.poll();
                sum += current.val;
                count++;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            answer.add((double) sum / count);
            sum = count = 0;
        }
        return answer;
    }
}