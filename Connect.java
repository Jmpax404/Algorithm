import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node sentinel = new Node();//dummy
        sentinel.next = root;
        Node pre = null;
        while (pre != sentinel) {
            pre = sentinel;
            for (Node cur = sentinel.next; cur != null; cur = cur.next) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
            }
        }
        return root;
    }

    public Node connect0(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node pre = null;
            for (int i = 0; i < n; i++) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}