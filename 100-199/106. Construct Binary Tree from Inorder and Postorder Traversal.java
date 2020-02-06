// same as previous problem

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return recur(map,inorder,postorder,postorder.length-1,0,inorder.length-1);
    }
    public TreeNode recur(HashMap<Integer,Integer> map,int[] inorder,int[] postorder,int post,int inSt,int inEnd){
        if(inEnd<inSt) return null;
        int index = map.get(postorder[post]);
        TreeNode node = new TreeNode(inorder[index]);
        node.left = recur(map,inorder,postorder,post-inEnd+index-1,inSt,index-1);
        node.right = recur(map,inorder,postorder,post-1,index+1,inEnd);
        return node;
    }
}
