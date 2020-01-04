// solution 1: traditional backtrack, find the 1st char and then move accross its neibours(if failed go back),
// use a 2-D array to record a char has been added or not
// solution 2: optimization for solution 1, avoid using 2-D array to mark scanned chars(just modify the char to be '*' or a 
// special identifier that will not be used in board[][])

// solution 1
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length==0 || word.length()==0) return false;
        char head = word.charAt(0);
        boolean scanned[][] = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==head){
                    scanned[i][j] = true;
                    if(backtrack(board,scanned,i,j,word,1)) return true;
                    else scanned[i][j] = false;
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board,boolean[][] scanned,int i,int j,String word,int len){
        if(len==word.length()) return true;
        if(i>0 && !scanned[i-1][j] &&word.charAt(len)==board[i-1][j]){
            scanned[i-1][j] = true;
            if(backtrack(board,scanned,i-1,j,word,len+1)) return true;
            else scanned[i-1][j] = false;
        }
        if(j>0 && !scanned[i][j-1] && word.charAt(len)==board[i][j-1]){
            scanned[i][j-1] = true;
            if(backtrack(board,scanned,i,j-1,word,len+1)) return true;
            else scanned[i][j-1] = false;
        }
        if(i<board.length-1 && !scanned[i+1][j] && word.charAt(len)==board[i+1][j]){
            scanned[i+1][j] = true;
            if(backtrack(board,scanned,i+1,j,word,len+1)) return true;
            else scanned[i+1][j] = false;
        }
        if(j<board[0].length-1 && !scanned[i][j+1] && word.charAt(len)==board[i][j+1]){
            scanned[i][j+1] = true;
            if(backtrack(board,scanned,i,j+1,word,len+1)) return true;
            else scanned[i][j+1] = false;
        }
        return false;
    }
}

//solution 2
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length==0 || word.length()==0) return false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backtrack(board,i,j,word,0)){
                     return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board,int i,int j,String word,int len){
        if(len==word.length()) return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return false;
        if(board[i][j] != word.charAt(len)) return false;
        board[i][j] = '*';
        boolean find = backtrack(board,i-1,j,word,len+1) || backtrack(board,i,j-1,word,len+1) || backtrack(board,i+1,j,word,len+1) || backtrack(board,i,j+1,word,len+1);
        board[i][j] = word.charAt(len);
        return find;
    }
}
