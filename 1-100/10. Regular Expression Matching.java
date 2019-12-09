// 1. recursively backtracking and return the result
// 2. add top-down dynamic programming to increase execution speed
// 3. bottum-up of dp
// comments for dp's detail logic is shown as below in solution 3

//solution 1
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length()==0){
            return s.length()==0;
        }
        if(s.length()==0){
            if(p.length()>1 && p.charAt(1)=='*') return isMatch(s,p.substring(2));
            return false;
        }
        
        boolean match = s.charAt(0)==p.charAt(0)||p.charAt(0)=='.';
        
        if(p.length()>1 && p.charAt(1)=='*'){
            return (match&&isMatch(s.substring(1),p) ) || isMatch(s,p.substring(2));
        }else{
            return match&&isMatch(s.substring(1),p.substring(1));
        }
        
    }
}

//solution 2
class Solution {
     public boolean isMatch(String s, String p) {
         // d[0][0] means when s and p is empty
         // d[m][n] stands for the substring of s and p(with length m,n) is mathch or not
         // that is, s.substring(s.length()-m) and p.substring(p.length()-m) are matching or not
         Boolean dp[][] = new Boolean[s.length()+1][p.length()+1];
         dp[0][0] = true;
         for(int i=1;i<s.length()+1;i++){
             dp[i][0] = false;
         }
         return getdp(s.length(),p.length(),dp,s,p);
    }
    
    public boolean getdp(int m,int n,Boolean[][] dp,String s,String p){
        if(dp[m][n]!=null) return dp[m][n];
        if(m==0){
            if(n>1 && p.charAt(p.length()-n+1)=='*'){
                dp[m][n] = getdp(m,n-2,dp,s,p);
                return dp[m][n];
            }
            return false;
        }
        char a = s.charAt(s.length()-m);
        char b = p.charAt(p.length()-n);
        boolean match = a==b || b=='.';
        
        if(n>1 && p.charAt(p.length()-n+1)=='*'){
            dp[m][n] = (match&&getdp(m-1,n,dp,s,p)) || getdp(m,n-2,dp,s,p);
            return dp[m][n];
        }else{
            dp[m][n] = match&&getdp(m-1,n-1,dp,s,p);
            return dp[m][n];
        }
    }
}

//solution 3
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean dp[][] = new Boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i=1;i<s.length();i++) dp[i][0] = false;
        
        // i stands length of substring of s (count from tail)
        // j stands length of substring of p (count from tail)
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                // p is empty, then if s is empty it's true, else false
                if(j==0) dp[i][j] = i==0;
                // s is empty
                else if(i==0){
                    // p ends with char+'*', like "bcd*"
                    if(j>1 && p.charAt(n-j+1)=='*'){
                        dp[i][j] = dp[i][j-2];
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    // both i and j are not 0
                    boolean match = s.charAt(m-i)==p.charAt(n-j) || p.charAt(n-j)=='.';
                    
                    // pattern like "ab" and "a*c"
                    if(j>1 && p.charAt(n-j+1)=='*'){
                        dp[i][j] = (match&&dp[i-1][j]) || dp[i][j-2];
                    }else{
                        dp[i][j] = match && dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
