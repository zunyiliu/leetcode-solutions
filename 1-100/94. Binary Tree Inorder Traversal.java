// solution 1 : recursive tree traversal
// solution 2 : stack based traversal, will break tree nodes' val to indicate a node has been travelled
// solution 2.1: modification of solution 2 to avoid breaking tree nodes' init values
// solution 3: another stack based solution, different concept as solution 2 and 2.1
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

// solution 2.1
class Solution {
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList();
		if(root == null) return res;
		Stack<TreeNode> stack = new Stack();
		stack.push(root);
		TreeNode cur = root.left;
		while(!stack.isEmpty()){
		    if(cur!=null) {
			stack.push(cur);
			cur = stack.peek().left;
		    }else{
			TreeNode t = stack.pop();
			res.add(t.val);
			if(t.right!=null){
			    stack.push(t.right);
			    cur = stack.peek().left;
			} 
		    }
		}
		return res;
	}
}
