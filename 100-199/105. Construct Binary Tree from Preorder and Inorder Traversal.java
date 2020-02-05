// solution 1: recursive solution, preorder[0] must be the root of the tree, find this value in inorder[i], all nodes
// on the left side of i are the root's left tree, and right side of i are the root's right tree, recursively do it

// soltuion 1
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recur(preorder,inorder,0,0,inorder.length-1);
    }
    public TreeNode recur(int[] preorder, int[] inorder,int preSt,int oSt,int oEnd){
        if(oSt>oEnd) return null;
        int index = 0;
        for(int i=oSt;i<=oEnd;i++){
            if(inorder[i]==preorder[preSt]){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[preSt]);
        root.left = recur(preorder,inorder,preSt+1,oSt,index-1);
        root.right = recur(preorder,inorder,preSt+1+index-oSt,index+1,oEnd);
        return root;
    }
}
