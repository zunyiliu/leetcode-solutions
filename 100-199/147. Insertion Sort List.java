class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode dummy = new ListNode(-999);
        dummy.next = head;
        while(cur!=null){
            ListNode curnext = cur.next;
            pre = insert(dummy,pre,cur);
            cur = curnext;
        }
        return dummy.next;
    }
    public ListNode insert(ListNode dummy,ListNode pre,ListNode cur){
        ListNode preIn = dummy;
        ListNode curIn = dummy.next;
        while(curIn!=cur){
            if(curIn.val>cur.val){
                pre.next = cur.next;
                cur.next = curIn;
                preIn.next = cur;
                return pre;
            }else{
                preIn = preIn.next;
                curIn = curIn.next;
            }
        }
        return cur;
    }
}
