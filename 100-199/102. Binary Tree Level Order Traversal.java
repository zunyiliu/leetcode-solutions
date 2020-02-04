// solution 1: iterative solution, search level by level
// solution 2: level by level recursion
// solution 3: Preorder Traversal recursion

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

// solution 2
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        List<TreeNode> list = new ArrayList();
        list.add(root);
        recur(list,res);
        return res;
    }
    public void recur(List<TreeNode> list,List<List<Integer>> res){
        List<Integer> cur = new ArrayList();
        List<TreeNode> nextLevel = new ArrayList();
        for(int i=0;i<list.size();i++){
            TreeNode node = list.get(i);
            if(node!=null){
                cur.add(node.val);
                nextLevel.add(node.left);
                nextLevel.add(node.right);
            }
        }
        if(cur.size()>0) {
            res.add(cur);
            recur(nextLevel,res);
        }
    }
}

// solution 3
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverseTree(root, 0, result);
        return result;
    }
    
    private void traverseTree(TreeNode curr, int level, List<List<Integer>> result) {
        if (curr == null)
            return;
        
        if (level == result.size())
            result.add(new ArrayList<Integer>());
        
        result.get(level).add(curr.val);
        
        traverseTree(curr.left, level + 1, result);
        traverseTree(curr.right, level + 1, result);
    }
}
