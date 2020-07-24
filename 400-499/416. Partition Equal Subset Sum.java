class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        
        if(sum%2!=0) return false;
        sum /= 2;
        
        boolean dp[] = new boolean[sum+1];
        dp[0] = true;
        
        for(int i=0;i<nums.length;i++){
            // must loop from top to bottom, as all numbers nums[i] are int>=0
            // if start from bot up, and current num[i] is 1
            // from dp[0]==true will lead dp[1]==true
            // next you iterate dp[1] from dp[1]==true will get dp[2]==true
            // so on and so forth all dp[x] will become true
            for(int j=dp.length-1;j>=0;j--){
                if(dp[j] && j+nums[i]<=sum ){
                    dp[j+nums[i]] = true;
                }
            }
        }
        
        return dp[sum];
    }
}
