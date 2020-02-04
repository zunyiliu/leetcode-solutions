// solution 1: iterative solution, search level by level
// solution 2:

// solution 1
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        Queue<TreeNode> pre = new LinkedList();
        pre.add(root);
        while(!pre.isEmpty()){          
            Queue<TreeNode> cur = new LinkedList();
            List<Integer> list = new ArrayList();
            while(!pre.isEmpty()){
                TreeNode node = pre.poll();
                if(node.left!=null) cur.add(node.left);
                if(node.right!=null) cur.add(node.right);
                list.add(node.val);
            }
            pre = cur;
            res.add(list);
        }
        return res;
    }
}
