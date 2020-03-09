// in summary, post-order traverse is the hardest one while considering with iteration
// solution 1: stack-based iterative solution 
// solution 2: naive, recursion
// solution 3: morris traverse(postorder), use a dummy head and let dummy.left = root, start from dummy head
// do same morris traverse operation, the difference is while adding nodes, it starts from the 左转折点 then 
// reverse traverse from the right-most node to itself.

// solution 1
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

// solution 2
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        recur(root,list);
        return list;
    }
    public void recur(TreeNode node,List<Integer> list){
        if(node!=null){
            recur(node.left,list);
            recur(node.right,list);
            list.add(node.val);
        }
    }
}

// solution 3
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        root = dummy;
        List<Integer> list = new ArrayList();
        
        while(root!=null){
            TreeNode pre = root.left;
            if(pre!=null){
                while(pre.right!=null && pre.right!=root){
                    pre = pre.right;
                }
                if(pre.right==null){
                    pre.right = root;
                    root = root.left;
                }else{ // pre.right==root;
                    pre.right = null;
                    reverseAdd(root.left,list);
                    root = root.right;
                }
            }else{
                root = root.right;
            }
        }
        return list;
    }
    public void reverseAdd(TreeNode node,List<Integer> list){
        if(node!=null){
            reverseAdd(node.right,list);
            list.add(node.val);
        }
    }
}
