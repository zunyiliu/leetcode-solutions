// solution 1: recursive method 1-2 -- 3-4 -- 5-6 to 1-6 -- 2-5 -- 3-4 observe the relation before and after change, can conclude
// the recursive function

// solution 2: 3 steps, 1st -- split the list into two parts with same length
//                      2nd -- reverse list for the second part
//                      3rd -- merge two lists

// solution 1
class Solution {
    public void reorderList(ListNode head) {
        ListNode tmp = head;
        int len = 0;
        while(tmp!=null){
            tmp = tmp.next;
            len++;
        }
        if(len==0) return ;
        else recur(head,len);
    }
    public ListNode recur(ListNode head,int len){
        ListNode rt;
        if(len==1){
            rt = head.next;
            head.next = null;
        }else if(len==2){
            rt = head.next.next;
            head.next.next = null;
        }else{
            ListNode headnext = head.next;
            head.next = recur(headnext,len-2);
            rt = head.next.next;
            head.next.next = headnext;
        }
        return rt;
    }
}

// solution 2
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        // step 1
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // step 2
        ListNode pre = slow.next, cur = pre.next;
        slow.next = null;
        pre.next = null;
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        
        // step 3, from step 1 we know part1's length must be longger or equal to part2
        ListNode p2 = pre, p1 = head;
        while(p2!=null){
            ListNode tmp1 = p1.next;
            ListNode tmp2 = p2.next;
            p1.next = p2;
            p2.next = tmp1;
            p1 = tmp1;
            p2 = tmp2;
        }
    }
}
