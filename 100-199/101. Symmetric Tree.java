// solution 1: recursion, for symmetric tree, a root's left tree must symmetric with its right tree. For two trees that are symmetric.
// 1st requirement is the root.val of the two trees are equal, then 1st tree's left subtree is symmetric with 2nd tree's right tree.
// 1st tree's right tree is symmetric with 2nd tree's left tree. From now a recursion method is intuitive obtained.

// solution 2: iterative solution using stack(queue also works)

// solution 1
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return sym(root.left,root.right);
    }
    public boolean sym(TreeNode left,TreeNode right){
        if(left==null && right==null) return true;
        if( (left==null && right!=null) ||(left!=null&&right==null) ) return false;
        if(left.val!=right.val) return false;
        return sym(left.left,right.right) && sym(left.right,right.left);
    }
}

// solution 2
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        s.push(root);
        s.push(root);
        while(!s.isEmpty()){
            TreeNode t1 = s.pop();
            TreeNode t2 = s.pop();
            if(t1==null && t2==null) continue;
            if( (t1!=null&&t2==null) || (t1==null&&t2!=null) ) return false;
            if(t1.val != t2.val) return false;
            s.push(t1.left);
            s.push(t2.right);
            s.push(t1.right);
            s.push(t2.left);
        }
        return true;
    }
}
