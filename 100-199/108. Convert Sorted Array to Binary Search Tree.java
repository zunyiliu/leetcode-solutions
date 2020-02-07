// easy solution

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums,0,nums.length-1);
    }
    public TreeNode recur(int[] nums,int st,int end){
        if(st>end) return null;
        int index = (st+end)/2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = recur(nums,st,index-1);
        root.right = recur(nums,index+1,end);
        return root;
    }
}
