// dynamic programming plus three pointers, track the sequence of nth ugly number, 
// the pattern of a next ugly number is the smallest number among dp[pointer2] * 2, dp[pointer3] * 3, dp[pointer5] * 5
class Solution {
    public int nthUglyNumber(int n) {
        int dp[] = new int[n];
        dp[0] = 1;
        
        int p2 = 0, p3 = 0, p5 = 0;
        
        for (int i = 1; i < n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            
            int min = Math.min(num2 < num3? num2:num3,num5);
            dp[i] = min;
            
            if (num2 == min) {
                p2++;
            }
            if (num3 == min) {
                p3++;
            }
            if (num5 == min) {
                p5++;
            }
        }
        
        return dp[n-1];
    }
}
