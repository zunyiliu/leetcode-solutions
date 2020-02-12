// solution 1: 2-D array, bot-up DP
// solution 2: top-down DP

// solution 1
class Solution {
    public int numDistinct(String s, String t) {
        int [][]memo = new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length()+1;i++) memo[i][0] = 1;                
        for(int j=1;j<t.length()+1;j++) memo[0][j] = 0;
        
        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<t.length()+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)) memo[i][j]=memo[i-1][j-1]+memo[i-1][j];
                else memo[i][j] = memo[i-1][j];
            }
        }
        return memo[s.length()][t.length()];
    }
}

// solution 2
class Solution {
    public int numDistinct(String s, String t) {
        Integer [][]memo = new Integer[s.length()+1][t.length()+1];
        return recur(s.length(),t.length(),s,t,memo);
    }
    public int recur(int m,int n,String s,String t,Integer[][] memo){
        if(memo[m][n]!=null) return memo[m][n];
        if(n==0) return memo[m][n] = 1;
        if(m==0) return memo[m][n] = 0;
        if(s.charAt(m-1)==t.charAt(n-1)) 
            return memo[m][n] = recur(m-1,n-1,s,t,memo)+recur(m-1,n,s,t,memo);
        else return memo[m][n] = recur(m-1,n,s,t,memo);
    }
}
