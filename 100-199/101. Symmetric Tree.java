// solution 1: recursion, for symmetric tree, a root's left tree must symmetric with its right tree. For two trees that are symmetric.
// 1st requirement is the root.val of the two trees are equal, then 1st tree's left subtree is symmetric with 2nd tree's right tree.
// 1st tree's right tree is symmetric with 2nd tree's left tree. From now a recursion method is intuitive obtained.

// solution 2:

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
