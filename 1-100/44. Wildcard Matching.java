// solution 1: bottom up DP, backtracking should also work but exceed the time limit here(in another similar problem, recursively 
backtracking also works)
// solution 2: top-down DP

// solution 1
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(),n = p.length();
        Boolean memo[][] = new Boolean[m+1][n+1];
        
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(j==0){
                    memo[i][j] = i==0;
                }else if(i==0){
                    if(p.charAt(n-j)=='*')
                        memo[i][j] = memo[i][j-1]; 
                    else 
                        memo[i][j] = false;
                }else{
                    boolean match = s.charAt(m-i)==p.charAt(n-j) || p.charAt(n-j)=='?';
                    if(match){
                        memo[i][j] = memo[i-1][j-1];
                    }else{
                        if(p.charAt(n-j)=='*')
                            memo[i][j] = memo[i-1][j] || memo[i][j-1];
                        else
                            memo[i][j] = false;
                    }
                }
            }
        }
        return memo[m][n];
    }
}
