// solution 1: DP, build from bottom, dp[i] represents the min coin that are needed for summing up to number i, if dp[i] = Integer.MAX_VALUE then 
// no such coin combinations exist

// solution 2: BFS

// solution 1
class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i && dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(1+dp[i-coins[j]],dp[i]);
                }
            }
        }
        
        return dp[amount]==Integer.MAX_VALUE? -1:dp[amount];
    }
}
