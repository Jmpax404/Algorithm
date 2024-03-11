import java.util.HashMap;

public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        for (Node cur = head; cur != null; cur = cur.next.next) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
        }
        for (Node cur = head; cur != null; cur = cur.next.next) {
            cur.next.random = cur.random == null ? null : cur.random.next;
        }
        Node headNew = head.next;
        for (Node cur = head; cur != null; cur = cur.next) {
            Node curNew = cur.next;
            cur.next = cur.next.next;
            curNew.next = cur.next == null ? null : curNew.next.next;
        }
        return headNew;
    }

    public Node copyRandomList1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();//可以放到class中当作全局变量
        return copyNode(head, map);
    }

    private Node copyNode(Node node, HashMap<Node, Node> map) {
        if (node == null) {
            return null;
        }
        Node ans = null;
        if ((ans = map.get(node)) == null) {
            ans = new Node(node.val);
            map.put(node, ans);
            ans.next = copyNode(node.next, map);
            ans.random = copyNode(node.random, map);
        }
        return ans;
    }

    public Node copyRandomList0(Node head) {
        HashMap<Node, Node> map = new HashMap<>();//对象比较的就是HashCode
        Node newHead = new Node(0);
        Node newPre = newHead;
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newPre.next = newNode;
            newPre = newNode;
            map.put(cur, newNode);
            cur = cur.next;
        }
        cur = head;
        Node newCur = newHead.next;
        while (cur != null) {
            Node randomNode = cur.random;
            if (randomNode != null) {
                newCur.random = map.get(randomNode);
            }
            newCur = newCur.next;
            cur = cur.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node ans = new Solution().copyRandomList(node1);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}