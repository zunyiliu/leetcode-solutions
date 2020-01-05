// each time scan current node and if it's valid add to list
// if not, move forward to the next node which has non-duplicate val as the current node, change cur's reference to the one move to
// then keep scanning current code until the end
// many edge cases should concern, like for the first node is duplicate, the last node is duplicate etc
// solution 1 may not good logic though runs fairly fast, wrote by myself


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
