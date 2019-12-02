// backtracking: the concept is not very hard, but it's easy to make a mistake, for better understanding, I should come back and take this one more time later
public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board,0);
    }
    public boolean solve(char[][]board,int start_row){
        for(int i=start_row;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(valid(board,i,j,c)){
                            board[i][j] = c;
                            if(solve(board,i)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean valid(char[][] board,int start_i,int start_j,char c){
        for(int num=0;num<9;num++){
            //check column, row, and cubes
            if(board[num][start_j]==c) return false;
            if(board[start_i][num]==c) return false;
            if(board[3*(start_i/3)+num/3][3*(start_j/3)+num%3]==c) return false;
        }
        return true;
    }
}
