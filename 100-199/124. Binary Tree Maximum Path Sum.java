// solution 1: naive dfs, the first kep point is that a path here can't fork, so, dfs all nodes, for each node assume it
// is a starting root point and calculating the path sum, return the max one
class Solution {
    int max = -9999999;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    public void dfs(TreeNode root){
        if(root!=null){
            max = Math.max(calculate(root),max);
            dfs(root.left);
            dfs(root.right);
        }
    }
    public int calculate(TreeNode root){
        int m = root.val;
        int l = root.left==null? -999999:recur(root.left);
        int r = root.right==null? -99999:recur(root.right);
        int landM = l+m;
        int randM = r+m;
        int landMandR = l+m+r;
        int res = Math.max(m,l);
        res = Math.max(res,r);
        res = Math.max(res,landM);
        res = Math.max(res,randM);
        res = Math.max(res,landMandR);
        return res;
    }
    public int recur(TreeNode n){
        if(n!=null){
            int left = recur(n.left);
            int right = recur(n.right);
            int res = Math.max(left,right)>0? Math.max(left,right):0;
            return res+n.val;
        }else return 0;
    }
}
