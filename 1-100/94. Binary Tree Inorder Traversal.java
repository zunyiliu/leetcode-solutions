// solution 1 : recursive tree traversal
// solution 2 : stack based traversal, will break tree nodes' val to indicate a node has been travelled
class Solution {
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList();
		walk(res,root);
		return res;
	}
	public void walk(List<Integer> res,TreeNode root){
		if(root!=null){
			walk(res,root.left);
			res.add(root.val);
			walk(res,root.right);
		}
	}
}

// solution 2
class Solution {
	public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            if(stack.peek().left!=null && stack.peek().left.val!=-9999) stack.push(stack.peek().left);
            else{
                TreeNode t = stack.pop();
                res.add(t.val);
                t.val = -9999;
                if(t.right!=null && t.right.val!=-9999) stack.push(t.right);
            }
        }
        return res;
    }
}
