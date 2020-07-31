// solution 1 O(n^2), loop s, each time expand around s.charAt(i) and record start&end index if palindrome is longer than before
// solution 2：can also be solved by using dp, dp[i][j] represents if s from index i to j is a palindrom
// solution 3: a more consice way for solution 1(same concept clearer code logic)
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        int start=0, end = 0;
        for(int i=0;i<s.length()-1;i++){
            int p1 = i;
            int p2 = i+1;
            while(p1>=0 && p2<s.length()){
                if(s.charAt(p1)==s.charAt(p2)){
                    p1--;
                    p2++;
                }else break;
            }
            if(p2-p1-1>end-start+1){
                start = p1+1;
                end = p2-1;
            }
            p1 = i-1;
            p2 = i+1;
            while(p1>=0 && p2<s.length()){
                if(s.charAt(p1)==s.charAt(p2)){
                    p1--;
                    p2++;
                }else break;
            }
            if(p2-p1-1>end-start+1){
                start = p1+1;
                end = p2-1;
            }   
        }
        return s.substring(start,end+1);
    }
}

// solution 2
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = -1;
        int st = 0;
        int end = 0;
        
        for(int i=0;i<dp.length;i++){
            for(int j=i;j>=0;j--){
                if(s.charAt(i)==s.charAt(j) && (i-j<=2||dp[j+1][i-1]) ){
                    dp[j][i] = true;
                    if(i-j+1>=max){
                        max = i-j+1;
                        st = j;
                        end = i;
                    }
                }
            }
        }
        
        return s.substring(st,end+1);
    }
}

// solution 3
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        int st = 0, end = -1;
        
        for(int i=0;i<s.length();i++){
            int len1 = expand(s,i,i);
            int len2 = expand(s,i,i+1);
            int len = len1>len2? len1:len2;
            
            if(end-st<len){
                st = i-(len-1)/2;
                end = len/2+i;
            }
        }
        
        return s.substring(st,end+1);
    }
    
    public int expand(String s,int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}
