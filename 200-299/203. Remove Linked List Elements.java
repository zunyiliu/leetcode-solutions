// easy level problem
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fake = new ListNode(-96);
        fake.next = head;
        ListNode cur = fake;
        
        while(cur.next!=null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        
        return fake.next;
    }
}
