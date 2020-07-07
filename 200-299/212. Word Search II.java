// Solution 1: purely backtracking, can pass all test cases but take too long time
// Solution 2: write a implementation data structure of trie(prefix tree), then do the backtracking with trie
// (the trie is implemented relatively complete, can apply the concept and modify the data structure to fullfill the requirement of the problem --> so that you
// will have a less code length and better run time performance)

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


// solution 2
class node{
    char val;
    boolean isWord;
    node[] children;
    public node(char val){
        this.val = val;
        this.children = new node[26];
        this.isWord = false;
    }
}

class trie{
    node root;
    public trie(){
        this.root = new node('0');
    }
    
    public void insert(String word){
        node cur = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur.children[ch-'a']==null){
                cur.children[ch-'a'] = new node(ch);
            }
            cur = cur.children[ch-'a'];
        }
        cur.isWord = true;
    }
    
    public boolean startsWith(String word){
        node cur = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur.children[ch-'a']==null){
                return false;
            }
            cur = cur.children[ch-'a'];
        }
        return true;
    }
    
    public boolean search(String word){
        node cur = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur.children[ch-'a']==null){
                return false;
            }
            cur = cur.children[ch-'a'];
        }
        return cur.isWord;
    }
    
    public void remove(String word){
        node cur = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            cur = cur.children[ch-'a'];
        }
        cur.isWord = false;
    }
}

class Solution {
    trie tree = new trie();
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList();
        for(int i=0;i<words.length;i++) tree.insert(words[i]);
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                backtrack(res,board,new String(),i,j);
            }
        }
        
        return res;
    }
    
    public void backtrack(List<String> res,char[][] board,String str,int i,int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return;
        if(board[i][j]=='#') return;
        
        char c = board[i][j];
        str += c;
        if(!tree.startsWith(str)) return;
        
        if(tree.search(str)){
            res.add(str);
            tree.remove(str);
        }
        board[i][j] = '#';
        backtrack(res,board,str,i+1,j);
        backtrack(res,board,str,i-1,j);
        backtrack(res,board,str,i,j+1);
        backtrack(res,board,str,i,j-1);
        board[i][j] = c;
    }
}
