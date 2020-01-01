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

//solution 2
class Solution {
    public int climbStairs(int n) {
        if(n==1||n==2) return n;
        int num1 = 1;
        int num2 = 2;
        int cur = 0;
        for(int i=3;i<=n;i++){
            cur = num1+num2;
            num1 = num2;
            num2 = cur;
        }
        return cur;
    }
}
