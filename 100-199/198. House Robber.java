// solution 1: bot-up
// solution 2: top-down

// solution 1
class Solution {
    public int rob(int[] nums) {
        if(nums.length<=1){
            return nums.length==1? nums[0]:0;
        }
        
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]); 
        }
        return dp[dp.length-1];
    }
}

// solution 2
class Solution {
    public int rob(int[] nums) {
        if(nums.length<=1){
            return nums.length==1? nums[0]:0;
        }
        
        Integer mem[] = new Integer[nums.length];
        mem[0] = nums[0];
        mem[1] = nums[0]>nums[1]? nums[0]:nums[1];
        return dp(nums.length-1,nums,mem);
    }
    
    public int dp(int index,int[] nums,Integer[] mem){
        if(mem[index]!=null) return mem[index];
        return mem[index] = Math.max(dp(index-1,nums,mem),dp(index-2,nums,mem)+nums[index]);
    }
}
