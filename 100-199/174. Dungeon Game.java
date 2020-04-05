// solution: dp, should start from end and expand gradually from end to start
// the solution below reverse the matrix diagnostically first, so the problem looks easier
// (can start from (0,0)), however if not rerverse it can still be solved with lesser time consumption(save reverse time)

class Solution {
    public int calculateMinimumHP(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        
        // reverse diagnostically so end and start point reversed(easy to do dp from left
        // top corner till right bot corner)
        reverse(matrix);
        
        dp[0][0] = matrix[0][0]>=0? 1:1-matrix[0][0];
        for(int i=1;i<m;i++){
            dp[i][0] = matrix[i][0]>=dp[i-1][0]? 1:dp[i-1][0]-matrix[i][0];
        }
        for(int j=1;j<n;j++){
            dp[0][j] = matrix[0][j]>=dp[0][j-1]? 1:dp[0][j-1]-matrix[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int tmpMin = Math.min(dp[i-1][j],dp[i][j-1]);
                dp[i][j] = matrix[i][j]>=tmpMin? 1:tmpMin-matrix[i][j];
            }
        }
        return dp[m-1][n-1];
    }
    
    // reverse diagnostically to make problem looks easier
    public void reverse(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        
        // reverse according to mid row
        for(int i=0;i<m/2;i++){
            for(int j=0;j<n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[m-1-i][j];
                matrix[m-1-i][j] = tmp;
            }
        }
        
        // reverse according to mid col
        for(int i=0;i<m;i++){
            for(int j=0;j<n/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
        
    }
}
