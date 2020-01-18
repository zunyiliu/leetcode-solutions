// solution 1: recursively reversing the portion of the list, and record the boundary nodes at the same time, finally concatenate 
// boundary nodes according to their right position
// e.g 1->2->3->4->5 m=2 n=5, ur task is to find boundary nodes, that's pre node 1, head of reverse portion 2, tail of reverse portion
// 5, pro node after 5 which is null, ur 1st task is to append them correctly, which is 1.next is 5, 2.next is null, while calling recursion
// ur 2nd task is to reverse the portion which is making 2->3->4->5 to become 5->4->3->2

// solution 2: recursion in a different mannaer (referenced by leetcode solution 1). reverse the order of the portion, e.g
// 2->3->4->5, swap 2 with 5, 3 with 4, to get the reversed portion (count is used for limiting swap operation, i.e. after swap 2 with 5
// and swap 4 with 3, u will go further and swap them back if not stop, this can also be achieved by applying a boolean value stop)

// solution 3: iterative solution modified by solution 1 (same concept)

// solution 1
class Solution {
    ListNode tail;
    ListNode rtail;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode pre = dummyhead;
        while(m>1){
            pre = pre.next;
            m--;
            n--;
        }
        ListNode rhead = pre.next;
        recur(rhead,n);
        pre.next = rtail;
        rhead.next = tail;
        return dummyhead.next;
    }
    public ListNode recur(ListNode st,int n){
        if(n==1){
            rtail = st;
            tail = st.next;
        }else{
            ListNode t = recur(st.next,n-1);
            t.next = st;
        }
        return st;
    }
}

// solution 2
class Solution {
    ListNode left;
    int count;
    public void recur(ListNode right, int m, int n,int tcount) {
        if(m>1) {
            left = left.next;
            recur(right.next,m-1,n-1,tcount);
        }else{
            if(n>=1){
                count++;
                tcount = count;
                recur(right.next,m-1,n-1,tcount);
                if(tcount>count/2) swap(right);
            }    
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        left = head;
        count = 0;
        recur(head,m,n,count);
        return head;
    }
    public void swap(ListNode right){
        int t = left.val;
        left.val = right.val;
        right.val = t;
        left = left.next;
    }
}

// solution 3
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head, pre = dummy;
        while (m > 1) {
            pre = pre.next;
            m--;
            n--;
        }
        cur = pre.next;
        ListNode pre_r = pre, cur_r = cur;
        while(n>0){
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
            n--;
        }
        pre_r.next = pre;
        cur_r.next = cur;
        
        return dummy.next;
    }
}
