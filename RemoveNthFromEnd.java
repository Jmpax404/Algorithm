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

class Solution {//链表解题经典三板斧，哑巴节点，栈，快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] list = new ListNode[30];
        int count = 0;
        for (ListNode cur = head; cur != null; cur = cur.next, count++) {
            list[count] = cur;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode next = n == 1 ? null : list[count - n + 1];
        ListNode pre = n == count ? dummy : list[count - n - 1];
        pre.next = next;
        return dummy.next;
    }
}