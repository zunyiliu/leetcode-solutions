//solution 1:same idea as problem 51, but there's a trick that don't need to actually build the 2D-array, in soluton 2
//solution 2

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
