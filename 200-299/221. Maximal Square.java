// solution 1: DP self come up solution with O(n^3) complexity, start from the top-left corner, dp[i][j] represents the 
// max square the cell can expand from itself to its top-left side
// iterate the dp array, if dp[i][j] can be expanded from dp[i-1][j-1]
// update it

// solution 2: DP with O(n^2), dp[i][j] represents the max width of the square it can expand from itself to its left-top side
// we can know dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1

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
                if(matrix[i][j]=='1'){
                    int width = (int) Math.sqrt(dp[i-1][j-1]);
                    dp[i][j] = expand(matrix,i,j,width);
                    max = Math.max(dp[i][j],max);
                }
            }
        }
        
        return max;
    }
    
    public int expand(char matrix[][],int row,int col,int width){       
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

// solution 2
class Solution {
   public int maximalSquare(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return 0;
        
        // init dp
        int dp[][] = new int[matrix.length+1][matrix[0].length+1];
        int w = 0;
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j])+1;
                    w = Math.max(w,dp[i][j]);
                }
            }
        }
        
        return w*w;
    }
}
