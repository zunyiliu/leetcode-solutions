// dfs
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        dfs(root,0);
        return sum;
    }
    public void dfs(TreeNode node,int path){
        if(node!=null){
            if(node.left==null && node.right==null){
                sum += path*10+node.val;
            }else{
                dfs(node.left,path*10+node.val);
                dfs(node.right,path*10+node.val);
            }
        }
    }
}
