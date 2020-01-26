// solution 1 : recursive tree traversal
// solution 2 : stack based traversal, will break tree nodes' val to indicate a node has been travelled
// solution 2.1: modification of solution 2 to avoid breaking tree nodes' init values
// solution 3: another stack based solution, different concept as solution 2 and 2.1
// solution 4.1: morris traverse, 4.1 will break tree and not recover the initial structure
// solution 4.2: morris traverse, 4.2 will recover the init structure

// solution 1
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

// solution 3
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
		Stack<TreeNode> stack = new Stack();
		TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}

// solution 4.1
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        TreeNode cur = root;
        TreeNode pre;
        while(cur!=null){
            if(cur.left==null){
                res.add(cur.val);
                cur = cur.right;
            }else{
                pre = cur.left;
                TreeNode t = pre;
                while(t.right!=null){
                    t = t.right;
                }
                t.right = cur;
                cur.left = null;
                cur = pre;
            }
        }
        return res;
    }
}

// solution 4.2
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        TreeNode cur = root;
        TreeNode pre;
        while(cur!=null){
            if(cur.left==null){
                res.add(cur.val);
                cur = cur.right;
            }else{
                pre = cur.left;
                while(pre.right!=null && pre.right!=cur){
                    pre = pre.right;
                }
                // if the structure has not been transformed
                if(pre.right==null){
                    pre.right = cur;
                    cur = cur.left;
                }else{ // if the structure has been transformed(then turn it back)
                    res.add(cur.val);
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
