import java.util.ArrayList;
import java.util.List;

public class PreOrderTraverse {//分解

    public List<Integer> preOrderTraverse(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        res.add(root.val);
        res.addAll(preOrderTraverse(root.left));
        res.addAll(preOrderTraverse(root.right));
        return res;
    }
}

class PreOrderTraverse0 {//遍历
    List<Integer> res;

    public List<Integer> preOrderTraverse(TreeNode root) {
        res = new ArrayList<>();
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
