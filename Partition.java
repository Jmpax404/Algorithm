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
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode();
        ListNode eBiggerHead = new ListNode();
        ListNode smallerCur = smallerHead;
        ListNode eBiggerCur = eBiggerHead;
        for (ListNode node = head; node != null; node = node.next) {
            if (node.val < x) {
                smallerCur.next = node;
                smallerCur = node;
            } else {
                eBiggerCur.next = node;
                eBiggerCur = node;
            }
        }
        smallerCur.next = eBiggerHead.next;
        eBiggerCur.next = null;
        return smallerHead.next;
    }
}