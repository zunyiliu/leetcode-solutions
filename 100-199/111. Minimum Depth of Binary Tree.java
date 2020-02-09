// solution: DFS O(n) time complexity, can be improved if applying level by level traverse(BFS)

class Solution {
    int min = 9999;
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        recur(root,1);
        return min;
    }
    public void recur(TreeNode root,int h){
        if(root.left==null&&root.right==null){
            min = Math.min(h,min);
        }else{
            if(root.left!=null) recur(root.left,h+1);
            if(root.right!=null) recur(root.right,h+1);
        }
    }
}
