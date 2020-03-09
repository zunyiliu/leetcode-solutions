// solution 1: trivial -- recursion 
// solution 2: naive -- stack based
// solution 3: morris traverse, similar as morris inorder traverse

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

// solution 3
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        
        while(root!=null){
            TreeNode pre = root.left;
            if(pre!=null){
                while(pre.right!=null && pre.right!=root){
                    pre = pre.right;
                }
                // pre.right == null
                if(pre.right==null){
                    list.add(root.val);
                    pre.right = root;
                    root = root.left;
                }else{ // pre.right == root
                    pre.right = null;
                    root = root.right;
                }
            }else{
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}
