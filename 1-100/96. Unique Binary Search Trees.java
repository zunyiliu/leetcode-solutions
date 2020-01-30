// check problem-96 to find further hints
// solution 1: top-down dp
// soliution 2: bot-up dp

// solution 1
class Solution {
    public int numTrees(int n) {
        if(n==0) return 0;
        int dp[] = new int[n+1];
        for(int i=0;i<dp.length;i++) dp[i] = -1;
        dp[0] = 1;
        dp[1] = 1;
        return recur(n,dp);
    }
    public int recur(int n,int[] dp){
        if(dp[n]!=-1) return dp[n];
        int count = 0;
        for(int i=1;i<=n;i++){
            count += recur(i-1,dp)*recur(n-i,dp);
        }
        return dp[n] = count;
    }
}

// solution 2

