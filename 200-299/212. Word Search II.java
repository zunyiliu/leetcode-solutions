// Solution 1: purely backtracking, can pass all test cases but take too long time
// Solution 2:

// solution 1: try all possible scenarios with backtracking
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList();
        
        for(int i=0;i<words.length;i++){
            if(find(words[i],board)) res.add(words[i]);
        }
        
        return res;
    }
    
    public boolean find(String word,char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backtrack(word,i,j,board,new boolean[board.length][board[0].length])) return true;
            }
        }
        return false;
    }
    
    public boolean backtrack(String word,int row,int col,char[][] board,boolean[][] visited){
        if(word.length()==0) return true;
        if(row<0 || col<0 || row>=board.length || col>=board[0].length) return false;
        if(visited[row][col] || word.charAt(0)!=board[row][col]) return false;
        
        // Now the board[row][col] must equal to the start of the word
        // and the board[row][col] has not been visited
        visited[row][col] = true;
        boolean found = backtrack(word.substring(1),row-1,col,board,visited)
            ||backtrack(word.substring(1),row,col-1,board,visited)
            ||backtrack(word.substring(1),row+1,col,board,visited) 
            || backtrack(word.substring(1),row,col+1,board,visited);
        if(found) return true;
        else{
            visited[row][col] = false;
            return false;
        }
    }
}
