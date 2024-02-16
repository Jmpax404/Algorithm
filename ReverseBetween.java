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

    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseNth(head, right, new ListNode[1]);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    private ListNode reverseNth(ListNode head, int n, ListNode[] remainerP) {
        if (n == 1) {
            remainerP[0] = head.next;
            return head;
        }
        ListNode last = reverseNth(head.next, n - 1, remainerP);
        head.next.next = head;
        head.next = remainerP[0];
        return last;
    }

    public ListNode reverseBetween0(ListNode head, int left, int right) {
        ListNode ans = new ListNode(0, head);
        head = ans;
        for (int i = 1; i < left; i++) {
            head = head.next;
        }
        ListNode node = head.next;
        for (int i = left; i < right; i++) {
            ListNode n2 = node.next;
            node.next = n2.next;
            n2.next = head.next;
            head.next = n2;
        }
        return ans.next;
    }
}
