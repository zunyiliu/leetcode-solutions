// in summary, post-order traverse is the hardest one while considering with iteration
// solution 1: stack-based iterative solution 
// solution 2: naive, recursion

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur = cur.left;
        }
        return reverse(list);
    }
    public List<Integer> reverse(List<Integer> list){
        List<Integer> reverselist = new ArrayList();
        for(int i=list.size()-1;i>=0;i--){
            reverselist.add(list.get(i));
        }
        return reverselist;
    }
}
