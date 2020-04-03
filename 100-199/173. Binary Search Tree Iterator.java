// stack based solution, O(h) -- 

class BSTIterator {
    
    List<TreeNode> list;
    
    public BSTIterator(TreeNode root) {
        list = new ArrayList(); 
        while(root!=null){
            list.add(0,root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode nextNode = list.remove(0);
        if(nextNode.right!=null){
            TreeNode cur = nextNode.right;
            while(cur!=null){
                list.add(0,cur);
                cur = cur.left;
            }
        }
        return nextNode.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !list.isEmpty();
    }
    
}
