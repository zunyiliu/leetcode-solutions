// hashtable, hashset
//use single hashtable to solve this
//a key string is encoded as cube num/column num/row num
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> table = new HashSet<>();
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    String row = board[i][j]+"row"+i;
                    String column = board[i][j]+"column"+j;
                    String cube = board[i][j]+"cube"+i/3+j/3;
                    if(table.contains(row)||table.contains(column)||table.contains(cube)){
                        return false;
                    }else{
                        table.add(row);
                        table.add(column);
                        table.add(cube);
                    }
                }
            }
        }
        return true;
    }
}
