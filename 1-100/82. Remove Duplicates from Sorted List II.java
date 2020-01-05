// each time scan current node and if it's valid add to list
// if not, move forward to the next node which has non-duplicate val as the current node, change cur's reference to the one move to
// then keep scanning current code until the end
// many edge cases should concern, like for the first node is duplicate, the last node is duplicate etc
// solution 1 may not good logic though runs fairly fast, initially wrote

// solution 2: modified optimization by applying a fake head (in linked-node operation this is a common method)
// solution 3: a slightly differen logic from leetcode

// solution 1
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode theHead = null;
        ListNode previous = null;
        ListNode cur = head; 
        while(cur!=null){
            if(scan(cur)){
                if(theHead==null){
                    theHead = cur;
                    previous = cur;
                    cur = cur.next;
                }else{
                    previous.next = cur;
                    previous = cur;
                    cur = cur.next;   
                }   
            }else{
                while(cur.next!=null){
                    if(cur.next.val == cur.val) cur = cur.next;
                    else{
                        break;
                    }
                }
                cur = cur.next;
            }
        }
        if(theHead==null) return null;
        else previous.next = cur;
        return theHead;
    }
    public boolean scan(ListNode cur){
        if(cur.next==null || cur.next.val!=cur.val) return true;
        return false;
    }
}

// solution 2
// this can also be optimized by not using cur2
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakehead = new ListNode(-99);
        ListNode pre = fakehead;
        ListNode cur = head;
        ListNode cur2;
        while(cur!=null){
            if(cur.next==null || cur.val!=cur.next.val){
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }else{
                cur2 = cur.next;
                while(cur2!=null && cur2.val==cur.val){
                    cur2 = cur2.next;
                }
                cur = cur2;
            }
        }
        pre.next = null;
        return fakehead.next;
    }
}

// solution 3
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakehead = new ListNode(-99);
        ListNode pre = fakehead;
        pre.next = head;
        ListNode cur = head;
        while(cur!=null){
            while(cur.next!=null && cur.next.val==cur.val) cur = cur.next;
            if(pre.next == cur){
                pre = cur;
            }else{
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return fakehead.next;
    }
}
