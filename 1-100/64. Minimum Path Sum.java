// solution 1: bot-up dp
// solution 2: top-down recursively dp
// same solution as No.63 and No.62

class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int memo[][] = new int[m][n];
        memo[0][0] = grid[0][0];
        for(int i=1;i<m;i++){
            memo[i][0] = memo[i-1][0]+grid[i][0];
        }
        for(int i=1;i<n;i++){
            memo[0][i] = memo[0][i-1]+grid[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                memo[i][j] = grid[i][j]+Math.min(memo[i-1][j],memo[i][j-1]);
            }
        }
        return memo[m-1][n-1];
    }
}
