class Solution {
    public TreeNode invertTree(TreeNode root) {
        flip(root);
        return root;
    }
    
    public void flip(TreeNode root){
        if(root!=null){
            TreeNode l = root.left;
            root.left = root.right;
            root.right = l;
            flip(root.left);
            flip(root.right);
        }
    }
}
