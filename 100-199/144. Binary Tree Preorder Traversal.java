// solution 1: trivial -- recursion 
// solution 2: morris traverse

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        recur(root,list);
        return list;
    }
    public void recur(TreeNode node, List<Integer> list){
        if(node!=null){
            list.add(node.val);
            recur(node.left,list);
            recur(node.right,list);
        }
    }
}
