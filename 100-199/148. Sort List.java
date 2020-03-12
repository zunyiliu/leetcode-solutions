// merge sort, not exactly O(1) space complexity since its a recursion, and recursion uses implicit stack space

class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowpre = null;
        while(fast!=null && fast.next!=null){
            slowpre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slowpre.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        head = merge(l1,l2);
        return head;
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(l1 != null && l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        while(l1!=null){
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        while(l2!=null){
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        return head.next;
    }
}
