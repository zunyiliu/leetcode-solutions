// solution 1: recursion, should mind the trap -- a BST is that for any node in the tree, its' value is bigger than its left subtree and smaller than
// its right subtree(must observe the upper bound and lower bound of each node)

// solution 1
class Solution {
    public boolean isValidBST(TreeNode root) {
        return valid(root,-98765,98765);
    }
    public boolean valid(TreeNode node,int bot,int ceil){
        if(node==null) return true;
        if(bot!=-98765 && node.val<=bot) return false;
        if(ceil!=98765 && node.val>=ceil) return false;
        return valid(node.right,node.val,ceil) && valid(node.left,bot,node.val); 
    }
}
