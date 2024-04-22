public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();// 头
        ListNode pre = dummy; // 符合要求的最后一个节点
        ListNode first = head;// 相同元素的第一个
        ListNode cur = head.next;// 当前遍历的节点，永远是相同元素的下一个
        while (cur != null) {
            if (cur.val != first.val) {
                if (first.next == cur) {// 说明没有重复元素
                    pre.next = first;
                    pre = first;
                }
                first = cur;// 换元素说明first需要重新设置
            }
            cur = cur.next;
        }
        if (first.next == null) {// 看最后一个元素的值的元素是不是只有一个
            pre.next = first;// 链表封闭
        } else {
            pre.next = null;
        }
        return dummy.next;
    }
}
