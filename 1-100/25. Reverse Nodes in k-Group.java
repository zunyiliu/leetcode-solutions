1. recursion: recursively add k's nodes onto a temporary array, if the remaining number of nodes on the list is smaller k, not reverse their
pointers, otherwise reverse their order, then new tail.next = reverseKGroup(previous's tail.next)

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        
        ListNode temp[] = new ListNode[k];
        boolean longenough = true;
        for(int i=0;i<k;i++){
            if(head!=null){
                temp[i] = head;
                head = head.next;
            }else{
                longenough = false;
                break;
            }
        }
        ListNode nextStart = head;
        if(longenough){
            for(int i=k-1;i>=1;i--){
                temp[i].next = temp[i-1];
            }
            temp[0].next = reverseKGroup(head,k);
            return temp[k-1];
        }else{
            return temp[0];
        }
    }
}
