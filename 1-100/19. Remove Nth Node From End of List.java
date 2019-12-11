//solution 1: use a List to record all nodes, and delete the corresponding position's node --> one pass
//solution 2: use two pointers, right pointer firstly move n steps so that left and right pointer can have a n distance gap,
then move left and right pointers to the end, while right reaching the end, left.next is the node you should delete
// ***notice -- you can add a dummy node ahead of head, so that particular case can be ignored(when head want to be deleted)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> memo = new ArrayList<>();
        while(head!=null){
            memo.add(head);
            head = head.next;
        }
        if(n==memo.size()) return memo.size()==1? null:memo.get(1); 
        memo.get(memo.size()-n-1).next = memo.get(memo.size()-n).next;
        return memo.get(0);
    }
}

//solution 2
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right = head;
        ListNode left = head;
        for(int i=0;i<n;i++){
            right = right.next;
        }
        if(right == null){
            return head.next;
        }else{
            right = right.next;
        }
        while(right!=null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
    }
}
