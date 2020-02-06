// solution 1: DFS recursion
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        recur(res,root,0);
        return res;
    }
    public void recur(List<List<Integer>> res, TreeNode root, int level){
        if(root==null) return;
        if(level == res.size()) res.add(0,new ArrayList());
        res.get(res.size()-level-1).add(root.val);
        recur(res,root.left,level+1);
        recur(res,root.right,level+1);
    }
}
