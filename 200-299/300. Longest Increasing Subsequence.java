// solution 1: dp O(n^2), init array dp[], dp[i] represents the longest length of increasing subsequence ends in nums[i], 
// dp[i] = max of dp[j] + 1 (where nums[j] < nums[i] and j is between 0 and i-1)

// solution 2: binary search O(nlogn)

// solution 2
class Solution {
    public int lengthOfLIS(int[] nums) {
        int []dp = new int[nums.length];
        int max = 0;
        
        for(int i=0;i<nums.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
