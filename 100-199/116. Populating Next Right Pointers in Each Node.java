//solution 1: iterative solution, each time for a node root, iterate all nodes in current row and the children of the all nodes
// start node from the left most node of the children then iterate again
//solution 2: recursion
//solution 3: another recursion
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

class Solution {
    public Node connect(Node root) {
        recur(root);
        return root;
    }
    public void recur(Node root){
        if(root!=null && root.left!=null){
            Node cur = root;
            while(cur!=null){
                cur.left.next = cur.right;
                cur.right.next = cur.next==null? null:cur.next.left;
                cur = cur.next;
            }
            recur(root.left);
        }
    }
}
