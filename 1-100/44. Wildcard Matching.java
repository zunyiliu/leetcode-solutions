// solution 1: bottom up DP, backtracking should also work but exceed the time limit here(in another similar problem recursively 
// backtracking also works)
// solution 2: top-down DP, solution 2.1: same as 2, just indicate that void method can also be used
// solution 3:

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

//solution 2
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(),n = p.length();
        Boolean memo[][] = new Boolean[m+1][n+1];
        return backtrack(memo,m,n,s,p);
    }
    public boolean backtrack(Boolean memo[][],int m,int n,String s,String p){
        if(memo[m][n]!=null) return memo[m][n];
        if(n==0){
            return memo[m][n] = m==0; 
        }else if(m==0){
            if(p.charAt(p.length()-n)=='*') return memo[m][n]=backtrack(memo,m,n-1,s,p);
            else return memo[m][n] = false;
        }else{
            boolean match = s.charAt(s.length()-m)==p.charAt(p.length()-n)||p.charAt(p.length()-n)=='?';
            if(match){
                return memo[m][n] = backtrack(memo,m-1,n-1,s,p);
            }else{
                if(p.charAt(p.length()-n)=='*')
                    return memo[m][n] = backtrack(memo,m,n-1,s,p) || backtrack(memo,m-1,n,s,p);
                else return memo[m][n] = false;
            }
        }
    }
}

//solution 2.1
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(),n = p.length();
        Boolean memo[][] = new Boolean[m+1][n+1];
        backtrack(memo,m,n,s,p);
        return memo[m][n];
    }
    public void backtrack(Boolean memo[][],int m,int n,String s,String p){
        if(memo[m][n]==null){
            if(n==0){
                memo[m][n] = m==0; 
            }else if(m==0){
                if(p.charAt(p.length()-n)=='*'){
                    backtrack(memo,m,n-1,s,p);
                    memo[m][n] = memo[m][n-1];
                }
                else memo[m][n] = false;
            }else{
                boolean match = s.charAt(s.length()-m)==p.charAt(p.length()-n)||p.charAt(p.length()-n)=='?';
                if(match){
                    backtrack(memo,m-1,n-1,s,p);
                    memo[m][n] = memo[m-1][n-1];
                }else{
                    if(p.charAt(p.length()-n)=='*'){
                        backtrack(memo,m,n-1,s,p);
                        backtrack(memo,m-1,n,s,p);
                        memo[m][n] = memo[m][n-1] || memo[m-1][n];
                    }
                        
                    else memo[m][n] = false;
                }
            }
        }
    }
}
