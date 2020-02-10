// easy
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        return recur(root,sum);
    }
    public boolean recur(TreeNode root,int sum){
        if(root.left==null && root.right==null) return sum-root.val==0;
        boolean l = false;
        boolean r = false;
        if(root.left!=null) l = recur(root.left,sum-root.val);
        if(root.right!=null) r = recur(root.right,sum-root.val);
        return l||r;
    }
}
