// backtracking: for int from start to end, each element is a middle parent node, and its left part becomes its left subtree,
// and right vice versa. So, recursively call this method, u can get all possible combinations
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n<=0) return new ArrayList();
        return recur(1,n);
    }
    public List<TreeNode> recur(int st,int end){
        List<TreeNode> subtree = new ArrayList();
        if(st==end || st>end){
            subtree.add(st==end? new TreeNode(st):null);
            return subtree;
        }
        for(int i=st;i<=end;i++){
            List<TreeNode> rightTree = recur(i+1,end);
            List<TreeNode> leftTree = recur(st,i-1);
            for(TreeNode rcomb:rightTree){
                for(TreeNode lcomb:leftTree){
                    TreeNode t = new TreeNode(i);
                    t.left = lcomb;
                    t.right = rcomb;
                    subtree.add(t);
                }
            }
        }
        return subtree;
    }
}
