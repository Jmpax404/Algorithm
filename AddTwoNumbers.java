
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;//'first' must be equal with pre where at first
        int carry = 0;
        ListNode pre = new ListNode();
        while (true) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + carry;
            if (l1 != null) {
                l1.val = sum % 10;
                pre = pre.next = l1;
            } else if (l2 != null) {
                l2.val = sum % 10;
                pre = pre.next = l2;
            } else {
                if (carry != 0) {
                    pre.next = new ListNode(carry);
                }
                break;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return first;
    }
}