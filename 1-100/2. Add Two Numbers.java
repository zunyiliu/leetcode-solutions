// Linked List manipulation

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode cur = null;
        ListNode head = null;
        while(l1!=null && l2!=null){
            int res = l1.val+l2.val+carry;
            sum = res%10;
            carry = res/10;
            if(cur!=null){
                cur.next = new ListNode(sum);
                cur = cur.next;
            }else{
                cur = new ListNode(sum);
                head = cur;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1==null){
            while(l2!=null){
                int res = carry+l2.val;
                sum = res%10;
                carry = res/10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if(l2==null){
            while(l1!=null){
                int res = carry+l1.val;
                sum = res%10;
                carry = res/10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                l1 = l1.next;
            }
        }
        if(carry>0){
            cur.next = new ListNode(carry);
        }
        return head;
    }
}
