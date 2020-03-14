// solution 1: build a cycle then use floyd algorithm to do the job
// solution 2: just link a's tail to b's head, and b's tail to a's head, brilliant solution 

// solution 1
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

// solution 2
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        // assume a and b have intersection, a consists of x + z length
        // b consists of y + z length while z is their overlapping part
        // 1. if x == y then in the 1st iteration they will meet
        // 2. if x != y, then in the 2nd iteraiton they will meet
        // (move two pointers together, while a reaches end points a to b's head,
        // while b reaches end points b to a's head)
        // thus when a moves x+z+y steps and b moves y+z+x steps they will meet
        // and this is the intersection node
        // 3. if a and b has no intersection, then a==b only happends at the
        // end of 2nd iteration, while they both reach tail thus they are both equal to null
        while(a!=b){
            if(a!=null) a = a.next;
            else a = headB;
            
            if(b!=null) b = b.next;
            else b = headA;
        }
        return b;
    }
}
