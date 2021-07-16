class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int lives = helper(board,i,j);
                
                if (lives >= 2 && lives <= 3 && board[i][j] == 1) {
                    board[i][j] += 2;
                }
                if (lives == 3 && board[i][j] == 0) {
                    board[i][j] += 2;
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    
    public int helper(int[][] board, int m, int n) {
        int startRow = Math.max(m-1,0);
        int startCol = Math.max(n-1,0);
        int endRow = Math.min(m+1,board.length-1);
        int endCol = Math.min(n+1,board[0].length-1);
        
        int count = 0;
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if ((board[i][j] & 1) == 1) {
                    count++;
                }
            }
        }
        
        if ((board[m][n] & 1) == 1) count--;
        
        return count;
    }
}
