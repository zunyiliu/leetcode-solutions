// do 1st iteration for setting flag to determine if a row/col should be marked as 0
// iterate memo of flag and do setting job

class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0) return;
        // record row and col for if they've implemented replacing 0
        boolean memo[][] = new boolean[2][Math.max(matrix.length,matrix[0].length)];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){ 
                    memo[0][i] = true;
                    memo[1][j] = true;
                }
            }
        }
        
        for(int i=0;i<memo.length;i++){
            for(int j=0;j<memo[0].length;j++){
                if(memo[0][j])
                    for(int col=0;col<matrix[0].length;col++) matrix[j][col] = 0;
                if(memo[1][j])
                    for(int row=0;row<matrix.length;row++) matrix[row][j] = 0;   
            }
        } 
    }
}
