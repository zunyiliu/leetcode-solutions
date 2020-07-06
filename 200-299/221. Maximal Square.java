// solution 1DP: start from the top-left corner, dp[i][j] represents the 
// max square the cell can expand from itself to its top-left side
// iterate the dp array, if dp[i][j] can be expanded from dp[i-1][j-1]
// update it, if not dp[i][j] = dp[i-1][j-1]'

// solution 1
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return 0;
        
        // init dp
        int dp[][] = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            dp[i][0] = matrix[i][0]-'0';
            if(dp[i][0]!=0) max = 1;
        }
        
        for(int i=0;i<matrix[0].length;i++){
            dp[0][i] = matrix[0][i]-'0';
            if(dp[0][i]!=0) max = 1;
        }
        
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                int width = (int) Math.sqrt(dp[i-1][j-1]);
                dp[i][j] = expand(matrix,i,j,width);
                max = Math.max(dp[i][j],max);
            }
        }
        
        return max;
    }
    
    public int expand(char matrix[][],int row,int col,int width){
        if(matrix[row][col]=='0') return 0;
        
        int temp = Math.min(row,col);
        int min = Math.min(temp,width);
        
        int newW = 1;
        for(int i=1;i<=min;i++){
            if(matrix[row-i][col]=='1' && matrix[row][col-i]=='1'){
                newW++;
            }else{
                return newW*newW;
            }
        }
        return newW*newW;
    }
}
