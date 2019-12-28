// solution 1: dp, same solution as 62, with modification

//solution 1
class Solution {
    public int uniquePathsWithObstacles(int[][] obs) {
        if(obs.length==0) return 0;
        if(obs[0][0]==1) return 0;
        int m = obs.length;
        int n = obs[0].length;
        int memo[][] = new int[m][n];
        memo[0][0] = 1;
        for(int i=1;i<m;i++){
            if(obs[i][0]==0) memo[i][0] = memo[i-1][0];
            else memo[i][0] = 0;
        }
        for(int j=1;j<n;j++){
            if(obs[0][j]==0) memo[0][j] = memo[0][j-1];
            else memo[0][j] = 0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obs[i][j]==1) memo[i][j] = 0;
                else memo[i][j] = memo[i-1][j]+memo[i][j-1];
            }
        }
        return memo[m-1][n-1];
    }
}
