public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        //find middle
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPre = null;
        while (fast != null && fast.next != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //cut two
        if (slowPre == null) {//only one element
            return head;
        }
        slowPre.next = null;
        //sort two
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(slow);
        //connect
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        while (list1 != null) {
            node.next = list1;
            list1 = list1.next;
            node = node.next;
        }
        while (list2 != null) {
            node.next = list2;
            list2 = list2.next;
            node = node.next;
        }
        node.next = null;
        return dummy.next;
    }

}
