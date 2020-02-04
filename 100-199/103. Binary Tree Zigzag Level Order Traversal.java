// same as previous problem, a only issue is that be careful of the traverse order(dont reverse twice to make reversing operation 
// duplicated)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        List<TreeNode> pre = new ArrayList();
        pre.add(root);
        int level = 1;
        while(!pre.isEmpty()){          
            List<TreeNode> cur = new ArrayList();
            List<Integer> list = new ArrayList();
            for(int i=0;i<pre.size();i++){
                if(level==0) list.add(pre.get(pre.size()-i-1).val);
                else list.add(pre.get(i).val);
                
                if(pre.get(i).left!=null) cur.add(pre.get(i).left);
                if(pre.get(i).right!=null) cur.add(pre.get(i).right);
            }
            level = level==0? 1:0;
            pre = cur;
            res.add(list);
        }
        return res;
    }
}
