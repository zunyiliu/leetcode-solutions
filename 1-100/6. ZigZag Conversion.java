// solution1: operate according to description, after fiiling all chars into the correct position, read them with described direction
// other solution: each space can be calculated, so you can append them directly by iterating the length of S
class Solution {
    public String convert(String s, int numRows) {
        int re = s.length()/numRows + 1;
        int numOfColumn = re*2;
        char [][]list = new char[numRows][numOfColumn];
        boolean [][]mark = new boolean[numRows][numOfColumn];
        int row = 0, col = 0, count = 0;
        if(s.length() == 0) return "";
        if(numRows == 1) return s;
        loop:
        for(int i=0;i<re;i++){
            while(row<numRows){
                if(count == s.length()){
                    break loop;
                }else{
                    list[row][col] = s.charAt(count);
                    mark[row][col] = true;
                    row++;
                    count++;
                }
            }
            row--;
            col++;
            for(int j = 0;j<numRows-2;j++){
                if(count == s.length()){
                    break loop;
                }else{
                    row--;
                    list[row][col] = s.charAt(count);
                    mark[row][col] = true;
                    count++;    
                }
            }
            row--;
            col++;
        }
        
        String result = "";
        for(int i=0;i<numRows;i++){
            for(int j=0;j<=col;j++){
                if(mark[i][j]) result+=list[i][j];
            }
        }
        return result;
    }
}
