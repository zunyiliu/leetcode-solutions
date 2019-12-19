//solution 1:same idea as problem 51, but there's a trick that don't need to actually build the 2D-array, in soluton 2
//solution 2:use bitmap to operate and record the queens are right or not

//solution 1
class Solution {
    public int totalNQueens(int n) {
        char [][]mark = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mark[i][j] = '.';
            }
        }
        return recur(0,0,mark);
    }
    public int recur(int sum,int row,char[][]mark){
        for(int i=0;i<mark.length;i++){
            if(valid(mark,row,i)){
                if(row==mark.length-1){
                    sum++;
                }else{
                    mark[row][i] = 'Q';
                    sum = Math.max(sum,recur(sum,row+1,mark));
                    mark[row][i] = '.';
                }
            }
        }
        return sum;
    }
    public boolean valid(char[][] mark, int row, int col){
        for(int i=0;i<mark.length;i++){
            for(int j=0;j<mark.length;j++){
                if(mark[i][j]=='Q' && (col==j||Math.abs(row-i)==Math.abs(col-j)) ){
                    return false;
                }
            }
        }
        return true;
    }
}

//solution 2
class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        dfs(0,0,0,0,n);
        return count;
    }
    public void dfs(int row,int diag,int antidiag,int col,int n){
        if(row==n){
            count++;  
            return;
        } 
        for(int i=0;i<n;i++){
            int bitdiag = 1<<(row+i); 
            int bitantidiag = 1<<(i+n-row-1);
            int bitcol = 1<<i;
            boolean diagsafe = (diag&bitdiag)==0;
            boolean antidiagsafe = (antidiag&bitantidiag)==0;
            boolean colsafe = (bitcol&col) == 0;
            if(diagsafe&&antidiagsafe&&colsafe){
                dfs(row+1,1<<(row+i)|diag,1<<(i+n-row-1)|antidiag,1<<i|col,n);
            }
        }
    }
}
