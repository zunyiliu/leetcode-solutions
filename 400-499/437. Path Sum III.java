// solution 1: DFS, for each node, calculate the number of paths start from the node with dfs

class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        helper(root,sum);
        return count;
    }
    public void helper(TreeNode root,int sum){
        if(root==null) return;
        dfs(root,0,sum);
        helper(root.left,sum);
        helper(root.right,sum);
    }
    
    public void dfs(TreeNode node,int cur,int sum){
        if(node==null) return;
        cur += node.val;
        if(cur==sum) count++;
        
        dfs(node.left,cur,sum);
        dfs(node.right,cur,sum);
    }
}
