1. recursion(faster than 100% and less memory usage than 100%)--recursively re-append node sequences

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode headnext = head.next;
        head.next = swapPairs(headnext.next);
        headnext.next = head;
        
        return headnext;
    }
}
