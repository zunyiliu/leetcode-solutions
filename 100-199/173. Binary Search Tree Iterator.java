// stack based solution, O(h) space complexity-- the height of the tree(or logn) and O(1) in average time complexity
// O(n) totally for in stack and O(n) totally out stack, divided by Ns operation 2n/n = O(2) which is O(1) in average
// the arrayList here is actually play a role like a Stack 

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
