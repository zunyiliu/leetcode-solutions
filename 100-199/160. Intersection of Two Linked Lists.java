// build a cycle then use floyd algorithm to do the job

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a.next!=null){
            a = a.next;
        }
        while(b.next!=null){
            b = b.next;
        }
        // no intersection
        if(a!=b) return null;
        
        // build a cycle, use floyd's  algorithm
        a.next = headA;
        ListNode slow = headB;
        ListNode fast = headB;
        while(true){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast){
                break;
            }
        }
        while(slow!=headB){
            slow = slow.next;
            headB = headB.next;
        }
        // release cycle
        a.next = null;
        return slow;
    }
}
