// solution 1 : solve the problem in-place, use two pointers fast and slow, fast move 2 steps once and slow moves 1 step
// if there's a cycle they will definitely meet at some point, now set two pointers one starting from the head the other starting
// from the meeting node, move forward these two pointers 1 step each time and the first time they meet is the entry of the cycle

// solution 2 : naive using hashset

// solution 1
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

// solution 2
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet();
        while(head!=null){
            if(!set.contains(head)) set.add(head);
            else return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
