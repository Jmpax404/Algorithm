/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow=head;
        ListNode rapid=head.next;
        if(rapid==null){
            return false;
        }
        rapid=rapid.next;
        while(rapid!=null){
            if(rapid==slow){
                return true;
            }
            slow=slow.next;
            rapid=rapid.next;
            if(rapid==null){
                return false;
            }
            rapid=rapid.next;
        }
        return false;
    }
}