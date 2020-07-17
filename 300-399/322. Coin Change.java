// solution 1: DP, build from bottom, dp[i] represents the min coin that are needed for summing up to number i, if dp[i] = Integer.MAX_VALUE then 
// no such coin combinations exist

// solution 2: BFS

// solution 3: DFS, since we are finding the path with shortest steps, BFS is much better as DFS will go through all paths thus exceeding the time limit

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


// solution 3
class Solution {
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        dfs(coins,amount,0);
        return res==Integer.MAX_VALUE? -1:res;
    }
    
    public void dfs(int[] coins,int amount,int count){
        if(amount<0) return;
        if(amount==0){
            res = Math.min(count,res);
            return;
        }
        for(int i=0;i<coins.length;i++){
            dfs(coins,amount-coins[i],count+1);
        }
    }
}
