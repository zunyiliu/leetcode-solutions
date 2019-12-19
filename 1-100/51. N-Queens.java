//backtracking
//心得体会：backtrack把整个思路的递归树画出来很重要，一画出来就一目了然了，会比光凭脑子想容易很多
//key: use a pen, draw the recursion tree instead of thinking solution, a draft can make your mind clearer
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean mark[][] = new boolean[n][n];
        recur(0,res,mark);
        return res;
    }
    public void recur(int row,List<List<String>> res,boolean[][] mark){
        for(int i=0;i<mark.length;i++){
            if(valid(mark,row,i)){
                mark[row][i]=true;
                if(row==mark.length-1){
                    addnew(res,mark);
                }else{
                    recur(row+1,res,mark);
                }
                mark[row][i]=false;
            }
        }
    }
    public boolean valid(boolean[][] mark,int row,int col){
        for(int i=0;i<mark.length;i++){
            for(int j=0;j<mark.length;j++){
                if(mark[i][j]){
                    if(i==row||j==col||Math.abs(i-row)==Math.abs(j-col)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public void addnew(List<List<String>> res,boolean[][] mark){
        List<String> strs = new ArrayList();
        for(int i=0;i<mark.length;i++){
            StringBuilder line = new StringBuilder();
            for(int j=0;j<mark.length;j++){
                if(mark[i][j]) line.append('Q');
                else line.append('.');
            }
            strs.add(line.toString());
        }
        res.add(strs);
    }
}
