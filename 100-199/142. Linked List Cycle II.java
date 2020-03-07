public class Solution {
    //Floyd's algorithm
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) break;
        }
        if(fast==null || fast.next==null) return null;
        ListNode walk1 = head, walk2 = slow;
        while(walk1!=walk2){
            walk1 = walk1.next;
            walk2 = walk2.next;
        }
        return walk1;
    }
}
