// solution 1: in-place iterative
// solution 2: recursive

// solution 1
class Solution {
    ListNode tail;
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head!=null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}

// solution 2
class Solution {
    ListNode tail;
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        recur(head);
        head.next = null;
        return tail;
    }
    public void recur(ListNode cur){
        if(cur.next!=null){
            recur(cur.next);
            cur.next.next = cur;
        }else{
            tail = cur;
        }
    }
}
