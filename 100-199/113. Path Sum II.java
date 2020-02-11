// backtracking
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        if(root==null) return res;
        backtrack(root,sum,new ArrayList(),res);
        return res;
    }
    public void backtrack(TreeNode node,int sum,List<Integer> tmp,List<List<Integer>> res){
        tmp.add(node.val);
        if(node.left==null && node.right==null){
            if(sum==node.val){
                res.add(new ArrayList(tmp));
            }
        }else{
            if(node.left!=null) backtrack(node.left,sum-node.val,new ArrayList(tmp),res);
            if(node.right!=null) backtrack(node.right,sum-node.val,new ArrayList(tmp),res);
        }
    }
}
