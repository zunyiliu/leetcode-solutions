// very clear and easy
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode beforehead = before;
        ListNode afterhead = after;
        while(head!=null){
            if(head.val<x){
                before.next = head;
                before = before.next;
            }else{ 
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = afterhead.next;
        return beforehead.next;
    }
}
