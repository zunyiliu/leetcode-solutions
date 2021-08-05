// dp -- the analysis of transition is crucial, let's assume dp[i][j] is the max result if we burst balloons between index i and j
// the naive solution is dfs that tries all possibilities (impossible as balloons' number increases).
// think another way: set index M as the last balloon to burst, as it's the last balloon, we can know the left and right of balloon[M] are settled
// so we can get the transition formula dp[i][j] with last burst balloon in index M, then dp[i][j] = dp[i][M-1] + balloons[i-1]*balloons[M]*balloons[j+1] + dp[M+1][j]

class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int dp[][] = new int[len][len];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = -1;
            }
        }
        
        return topDown(nums,dp,0,len-1);
    }
    
    public int topDown(int[] nums, int[][] dp, int l, int r) {
        if (l > r) return 0;
        if (dp[l][r] != -1) return dp[l][r];
        
        int st = l == 0? 1:nums[l-1];
        int end = r == nums.length-1? 1:nums[r+1];
        
        if (l == r) {
            dp[l][r] = st*end*nums[l];
            return dp[l][r];
        }
        
        int max = -998;
        for (int i = l; i <= r; i++) {
            max = Math.max(max, topDown(nums,dp,l,i-1) + st*nums[i]*end +topDown(nums,dp,i+1,r));
        }
        
        dp[l][r] = max;
        return max;
    }
}
