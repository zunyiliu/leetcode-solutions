// hashtable, hashset
//use single hashtable to solve this
//a key string is encoded as cube num/column num/row num
//2. another fantasy transformation
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

//2. only loop i,j once and use coordination tranformation to add rows, columns, cubes at the same time!!!
public boolean isValidSudoku(char[][] board) {
    for(int i = 0; i<9; i++){
        HashSet<Character> rows = new HashSet<Character>();
        HashSet<Character> columns = new HashSet<Character>();
        HashSet<Character> cube = new HashSet<Character>();
        for (int j = 0; j < 9;j++){
            if(board[i][j]!='.' && !rows.add(board[i][j]))
                return false;
            if(board[j][i]!='.' && !columns.add(board[j][i]))
                return false;
            int RowIndex = 3*(i/3);
            int ColIndex = 3*(i%3);
            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                return false;
        }
    }
    return true;
}
