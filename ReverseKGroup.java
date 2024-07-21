public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        int count = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curDummy = dummy;
        ListNode node = head;
        while (node != null) {
            count++;
            if (count == k) {
                ListNode p2 = curDummy.next;
                ListNode p1 = p2.next;

                //处理反转
                for (int i = 1; i < k; i++) {
                    ListNode t = p1.next;
                    p2.next = t;
                    p1.next = curDummy.next;
                    curDummy.next = p1;
                    p1 = t;
                }

                //设置新的初值
                curDummy = p2;
                count = 0;
                node= p2;
            }
            node = node.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1);
        dummy.setNextAndReturnNext(1).setNextAndReturnNext(2).setNextAndReturnNext(3).setNextAndReturnNext(4).setNextAndReturnNext(5);
        new Solution().reverseKGroup(dummy.next, 3);

    }
}

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

    ListNode setNextAndReturnNext(int val) {
        this.next = new ListNode(val);
        return this.next;
    }
}