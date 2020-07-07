// inorder tree traversal
class Solution {
    int count = 0;
    int res = -999;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return res;
    }
    
    public void inorder(TreeNode root,int k){
        if(root!=null){
            inorder(root.left,k);
            count++;
            if(count==k){
                res = root.val;
            }
            inorder(root.right,k);
        }
    }
}
