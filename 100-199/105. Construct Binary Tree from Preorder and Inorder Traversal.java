// solution 1: recursive solution, preorder[0] must be the root of the tree, find this value in inorder[i], all nodes
// on the left side of i are the root's left tree, and right side of i are the root's right tree, recursively do it

// solution 2: optimisation, use hashmap to avoid duplicate index find

// other solution: hard solutions 
// https://leetcode.wang/leetcode-105-Construct-Binary-Tree-from-Preorder-and-Inorder-Traversal.html#%E8%A7%A3%E6%B3%95%E4%BA%8C-%E8%BF%AD%E4%BB%A3-%E6%A0%88

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

// solution 2
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return recur(map,preorder,inorder,0,0,inorder.length-1);
    }
    public TreeNode recur(HashMap<Integer,Integer> map,int[] preorder, int[] inorder,int preSt,int oSt,int oEnd){
        if(oSt>oEnd) return null;
        int index = map.get(preorder[preSt]);
        TreeNode root = new TreeNode(preorder[preSt]);
        root.left = recur(map,preorder,inorder,preSt+1,oSt,index-1);
        root.right = recur(map,preorder,inorder,preSt+1+index-oSt,index+1,oEnd);
        return root;
    }
}
