// depth first recursion
class Solution {
    int max = 0;
    public int maxDepth(TreeNode root) {
        recur(root,0);
        return max;
    }
    public void recur(TreeNode node,int lvl){
        if(node!=null){
            max = Math.max(lvl+1,max);
            recur(node.left,lvl+1);
            recur(node.right,lvl+1);
        }
    }
}
