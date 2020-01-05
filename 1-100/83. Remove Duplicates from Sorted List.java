class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakehead = new ListNode(-99);
        ListNode pre = fakehead;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val==pre.val) cur = cur.next;
            else{
                pre.next = cur;
                pre =  cur;
                cur = cur.next;
            }
        }
        pre.next = null;
        return fakehead.next;
    }
}
