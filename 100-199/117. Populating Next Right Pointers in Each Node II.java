// same concept as previous problem, more edge cases need to be considered

class Solution {
    public Node connect(Node root) {
        Node initroot = root;
        Node pre = null;
        Node head = null;
        while(initroot!=null){
            Node p = initroot;
            while(p!=null){
                //case both left and right of p are not null
                if(p.left!=null && p.right!=null){
                    if(head==null) head = p.left;
                    p.left.next = p.right;
                    if(pre!=null) pre.next = p.left;
                    pre = p.right;
                // only right==null
                }else if(p.left!=null){
                    if(head==null) head = p.left;
                    if(pre!=null) pre.next = p.left;
                    pre = p.left;
                // only left==null
                }else if(p.right!=null){
                    if(head==null) head = p.right;
                    if(pre!=null) pre.next = p.right;
                    pre = p.right;
                }
                p = p.next;
            }
            initroot = head;
            pre = null;
            head = null;
        }
        return root;
    }
}
