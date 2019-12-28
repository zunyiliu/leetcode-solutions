// solution 1: straightforward solution
// solution 2

// solution 1
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        List<ListNode> memo = new ArrayList<>();
        if(head==null) return null;
        while(head!=null){
            memo.add(head);
            head = head.next;
        }
        // k will do duplicate ops for those steps exceed the length of the list
        k = k%memo.size();
        for(int i=0;i<k;i++){
            memo.add(0,memo.remove(memo.size()-1));
        }
        for(int i=0;i<memo.size()-1;i++){
            memo.get(i).next = memo.get(i+1);
        }
        memo.get(memo.size()-1).next = null;
        return memo.get(0);
    }
}
