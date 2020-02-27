// O(1) space complexity, use two pointers fast and slow, fast moves 2 steps and slow moves 1 step each turn, if there's
// a cycle there must be a point that fast catches up slow, which means fast==slow, if not there must be a point that fast 
// reaches the end of the linked list 1

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null){
            fast = fast.next;
            if(fast==null) return false;
            fast = fast.next;
            slow = slow.next;
            if(slow==fast) return true;
        }
        return false;
    }
}
