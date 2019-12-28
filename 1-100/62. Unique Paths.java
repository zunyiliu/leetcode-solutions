// solution 1: use formula, just insert n-1/m-1 step into m+n-2 slots
// solution 2: dp starts from col 0 and row 0, init a 2D array storing steps needed to all positions
// add up the step up from (0,0) till (m-1,n-1), e.g -- the step to get a cell is 
// equal to the step reaching its above cell plus the step reaching its left: cell(m,n) = cell(m-1,n) + cell(m,n-1)

// solution 1
class Solution {
    public int uniquePaths(int m, int n) {
        // calculate C(N,K);
        // where N = m+n-2, K = n-1 or m-1;
        long res = 1;
        int K = Math.min(m-1,n-1);
        for(int i=1;i<=K;i++){
            res *= m+n-1-i;
            res /= i;
        }
        return (int)res;
    }
}

// solution 2
class Solution {
    public int uniquePaths(int m, int n) {
        int memo[][] = new int[m][n];
        for(int i=0;i<m;i++){
            memo[i][0] = 1;
        }
        for(int j=0;j<n;j++){
            memo[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                memo[i][j] = memo[i-1][j]+memo[i][j-1];
            }
        }
        return memo[m-1][n-1];
    }
}
