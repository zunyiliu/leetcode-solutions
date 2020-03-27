// solution 1: naive, O(n^2) time complexity and O(1) extra space

// solution 1
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length<=1) return;
        while(k>0){
            iteration(nums,k);
            k--;
        }
    }
    public void iteration(int[] nums,int k){
        int tmp = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            nums[i+1] = nums[i];
        }
        nums[0] = tmp;
    }
}
