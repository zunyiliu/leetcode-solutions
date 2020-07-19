// solution 1: dp, easy to understand
// e.g [1,2,3,4,5,6,7,8,9,10....16] we can know
// 1. all numbers equal to 2^n are having one 1 in its 32-bits expression
// 2. from the previous num's result you can know the currrent num's result -- use number 2^n to separate the nums into blocks, like [2-3] [4-8] [9-16] [17-32]
// a number from current block can be deducted from its previous block's number -- that is: 5 = 4+1, 6= 4+2, 7 = 4+3.......15 = 8+7

// solution 1
class Solution {
    public int[] countBits(int num) {
        int []dp = new int[num+1];
        if(num==0) return dp;
        dp[1] = 1;
        int c = 1;
        
        for(int i=2;i<=num;i++){
            if(i==c*2){
                dp[i] = 1;
                c *= 2;
            }else{
                dp[i] = dp[c]+dp[i-c];
            }
        }
        return dp;
    }
}
