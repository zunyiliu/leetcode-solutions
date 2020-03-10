// solution 1 and 2 are same logic, 2 from discussion forum, the better improvement of 2 is it's cleaner, organize a new list that stores
// sorted nodes, while solution 1 operates sorting in-place

// solution 1
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

// solution 2
class Solution {
   public ListNode insertionSortList(ListNode head) {
		if( head == null ){
			return head;
		}
		
		ListNode helper = new ListNode(0); //new starter of the sorted list
		ListNode cur = head; //the node will be inserted
		ListNode pre = helper; //insert node between pre and pre.next
		ListNode next = null; //the next node will be inserted
		//not the end of input list
		while( cur != null ){
			next = cur.next;
			//find the right place to insert
			while( pre.next != null && pre.next.val <= cur.val ){
				pre = pre.next;
			}
			//insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			pre = helper;
			cur = next;
		}
		
		return helper.next;
	}
}
