//solution 1: iterative solution, each time for a node root, iterate all nodes in current row and the children of the all nodes
// start node from the left most node of the children then iterate again
//solution 2: recursion
//solution 3: another recursion, same as solution 2 in concept
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

// solution 2
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

// solution 3
class Solution {
    public Node connect(Node root) {
        Node p = root;
        
        while(p!=null && p.left!=null){
            recur(p);
            p = p.left;
        }
        return root;
    }
    public void recur(Node p){
        while(p!=null){
            p.left.next = p.right;
            p.right.next = p.next==null? null:p.next.left;
            p  = p.next;
        }
    }
}
