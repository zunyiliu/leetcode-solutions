// solution 1: O(n) dp
// 1. use dp, we can know dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
// 2. we need to break the circle, so use two dps, one while dp[0] not rob, another while dp[0] rob

// solution 1
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0],nums[1]);
        
        // two dps, dp0 is the robber must rob nums[0]
        int dp0[] = new int[n];
        int dp1[] = new int[n];
        dp0[0] = nums[0];
        dp0[1] = nums[0];
        dp1[0] = 0;
        dp1[1] = nums[1];
        
        // iterate dp0[] from 2 to n-2 (as the last and first house are connected)
        for (int i = 2; i < n-1; i++) {
            dp0[i] = Math.max(dp0[i-2] + nums[i],dp0[i-1]);
        }
        
        // iterate dp1[]
        for (int i = 2; i < n; i++) {
            dp1[i] = Math.max(dp1[i-2] + nums[i],dp1[i-1]);
        }
        
        return Math.max(dp0[n-2],dp1[n-1]);
    }
}
