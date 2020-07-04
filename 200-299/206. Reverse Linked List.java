// solution 1: in-place iterative
// solution 2: recursive

// solution 1
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        List<ListNode> list = new ArrayList();
        
        while(head!=null){
            list.add(head);
            head = head.next;
        }
        
        head = list.get(list.size()-1);
        ListNode cur = head;
        for(int i=list.size()-2;i>=0;i--){
            cur.next = list.get(i);
            cur = list.get(i);
        }
        cur.next = null;
        return head;
    }
}

// solution 2
class Solution {
    ListNode tail;
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        recur(head);
        head.next = null;
        return tail;
    }
    public void recur(ListNode cur){
        if(cur.next!=null){
            recur(cur.next);
            cur.next.next = cur;
        }else{
            tail = cur;
        }
    }
}
