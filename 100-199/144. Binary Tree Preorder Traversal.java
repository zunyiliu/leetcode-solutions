// solution 1: trivial -- recursion 
// solution 2: naive -- stack based

// solution 1
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

// solution 2
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
        }
        return list;
    }
}
