// solution 1: backtracking, can only pass 99/101 of the test cases(too long input incurs time limit exceeded)

// solution 2: use 2D array to memorize some intermediate combinations' results so duplicate calculations are avoided
// the key point here is to notify those duplicates. E.G, s1 = "aab", s2="aac", s3="aaabxx"
// The recursive tree (i,j) would be (i,j stands for index of s1 and s2)
// for a given combination 1,2, it will form a string with aaa which accordance with s3 currently, but for the next char you will
// find in s3 is 'b', and the next char in both next index of s1 and s2 are not 'b'(this means 1,2 is invalid comb)
// however, you may recalculate this comb 1,2 many times since u can reach this comb by from 0,1 --> 0,2 --> 1,2 or 0,1 --> 1,1 --> 1,2
// or 1,0 --> 1,1 --> 1,2, thus incurs recalculations (remember the key point is avoidance of such recalculation, so a 2D array is 
// necessary to record previous result)

// solution 3: bot-up dp
// for any dp(i,j), its validity is determined by dp(i,j-1) and dp(i-1,j) with the corresponding recent char

// solution 4: top-down dp

// solution 5：same concept but use less memory size, only 1D array is still working
// solution 1
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        if(s1.length()==0) return s2.equals(s3);
        if(s2.length()==0) return s1.equals(s3);
        if(s1.charAt(0)==s2.charAt(0)){
            if(s1.charAt(0)!=s3.charAt(0)) return false;
            else return isInterleave(s1.substring(1),s2,s3.substring(1)) 
                || isInterleave(s1,s2.substring(1),s3.substring(1));
        }else{
            if(s1.charAt(0)==s3.charAt(0)) 
                return isInterleave(s1.substring(1),s2,s3.substring(1));
            if(s2.charAt(0)==s3.charAt(0))
                return isInterleave(s1,s2.substring(1),s3.substring(1));
            return false;
        }
    }
}

// solution 2
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        int memo[][] = new int[s1.length()+1][s2.length()+1];
        return recur(s1,s2,s3,0,0,memo);
    }
    public boolean recur(String s1,String s2,String s3,int i,int j,int memo[][]){
        if(memo[i][j]>0) return memo[i][j]==1? true:false;
        if(s1.length()==i) return s2.substring(j).equals(s3.substring(i+j));     
        if(s2.length()==j) return s1.substring(i).equals(s3.substring(i+j)); 
        
        boolean ans = (s1.charAt(i)==s3.charAt(i+j)) && recur(s1,s2,s3,i+1,j,memo);
        ans |= (s2.charAt(j)==s3.charAt(i+j)) && recur(s1,s2,s3,i,j+1,memo);
        memo[i][j] = ans? 1:2;
        return ans;
    }
}

// solution 3
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(); 
        if(l1+l2!=s3.length()) return false;
        boolean dp[][] = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        for(int i=1;i<=l1;i++) dp[i][0] = dp[i-1][0]? s1.charAt(i-1)==s3.charAt(i-1):false;
        for(int j=1;j<=l2;j++) dp[0][j] = dp[0][j-1]? s2.charAt(j-1)==s3.charAt(j-1):false;
        
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                dp[i][j] = dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1);
                dp[i][j] |= dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1);
            }
        }
        return dp[l1][l2];
    }
}

// solution 4
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(); 
        if(l1+l2!=s3.length()) return false;
        Boolean dp[][] = new Boolean[l1+1][l2+1];
        dp[0][0] = true;
        for(int i=1;i<=l1;i++) dp[i][0] = dp[i-1][0]? s1.charAt(i-1)==s3.charAt(i-1):false;
        for(int j=1;j<=l2;j++) dp[0][j] = dp[0][j-1]? s2.charAt(j-1)==s3.charAt(j-1):false;
        
        return DP(s1,s2,s3,l1,l2,dp);
    }
    public boolean DP(String s1,String s2,String s3,int l1,int l2,Boolean dp[][]){
        if(dp[l1][l2]!=null) return dp[l1][l2];
        dp[l1][l2] = DP(s1,s2,s3,l1-1,l2,dp) && s1.charAt(l1-1)==s3.charAt(l1+l2-1);
        dp[l1][l2] |= DP(s1,s2,s3,l1,l2-1,dp) && s2.charAt(l2-1)==s3.charAt(l1+l2-1);
        return dp[l1][l2];
    }
}

// solution 5
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];
    }
}  
