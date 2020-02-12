class Solution {
    public Node connect(Node root) {
        Node p = root;
        while(root!=null && root.left!=null){
            Node cur = root;
            while(cur!=null){
                cur.left.next = cur.right;
                cur.right.next = cur.next==null? null:cur.next.left;
                cur = cur.next;
            }
            root = root.left;
        }
        return p;
    }
}
