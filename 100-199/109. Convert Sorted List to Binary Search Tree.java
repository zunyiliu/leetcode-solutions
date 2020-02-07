// both solutions find the mid of the list first then recursively append its left and right subtree
// different ways of finding mid of the list

// solution 1
class Solution {
    ListNode preMid = null;
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        // cut left part of the List if applied
        if(preMid!=null) preMid.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
    public ListNode findMid(ListNode head){
        preMid = null;
        int count = 0;
        ListNode head2 = head;
        while(head2!=null){
            count++;
            head2 = head2.next;
        }
        for(int i=0;i<count/2;i++){
            preMid = head3;
            head = head.next;
        }
        return head;
    }
}

// solution 2
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode slow = head, pre = null, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null; //cut left sub list here
        TreeNode n = new TreeNode(slow.val);
        n.left = sortedListToBST(head);
        n.right = sortedListToBST(slow.next);
        return n;
    }
}
