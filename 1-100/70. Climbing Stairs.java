// fib number actually
// solution 1: top down dp
// solution 2: bot-up dp

// solution 1
class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n];
        return recur(dp,n);
    }
    public int recur(int dp[], int n){
        if(dp[n-1]!=0) return dp[n-1];
        if(n<=2) return dp[n-1] = n;
        else{
            return dp[n-1] =recur(dp,n-1)+recur(dp,n-2);
        }
    }
}
