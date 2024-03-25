class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode node1 = head;
        ListNode node2 = head.next;
        for (int i = 0; i < k; i++) {
            if (node2 == null) {
                node2 = head;
            }
            node2 = node2.next;
        }
        while (node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy.next = node1.next;
        if (cur == null) {
            return head;
        }
        node1.next = null;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return dummy.next;
    }
}