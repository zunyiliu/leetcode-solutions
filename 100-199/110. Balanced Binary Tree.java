// solution 1: high time complexity--O(n*logn), recursively check if a node is balanced by measuring its left tree and right tree's height
// if so then recursively check its left child and right child are also balanced

// solution 2: one pass solution O(logn), backtracking

// solution 1
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int h = Math.abs(height(root.left)-height(root.right));
        if(h<2) return isBalanced(root.left) && isBalanced(root.right);
        return false;
    }
    public int height(TreeNode node){
        if(node==null) return 0;
        else{
            int l = 1+height(node.left);
            int r = 1+height(node.right);
            return Math.max(l,r);
        }
    }
}

// solution 2
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return backtrack(root)!=-1;
    }
    public int backtrack(TreeNode node){
        if(node==null) return 0;
        int left = backtrack(node.left);
        int right = backtrack(node.right);
        if(Math.abs(left-right)>=2 || left==-1 || right==-1) return -1;
        return 1+Math.max(left,right);
    }
}
