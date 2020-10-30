// solution 1 O(n^2), loop s, each time expand around s.charAt(i) and record start&end index if palindrome is longer than before
// solution 2：can also be solved by using dp, dp[i][j] represents if s from index i to j is a palindrom
// solution 3: a more consice way for solution 1(same concept clearer code logic)

// solution 4: manachar's algorith（马拉车算法）O(n) time complexity
// key point: The symmetric string of a palindrome's sub-palindrome is also a palindrome
// 1. init -- insert '*'s into s so that the length of s will become odd, and thus don't need to consider both odd and even cases
//         -- insert '~' infront of s and '!' at the end of s to avoid edge cases (array index out of boundary)
//         -- now the string s will look like: e.g from "aba" to "~*a*b*a*!"
//         -- init a int[]dp, where dp[i] stands for the furthest the index the string can expand to get a palindrome of the newly created string
//         -- init two ints, a index and a furthest, where furthest is the furthest place the palindrome can be expanded we scanned yet, and index as the furthest palindrome's mid point
//            (the two ints can be minimized to 1, as we can only record the index who has the furthest palindrome)
// 2. iterate the dp[]. expand as far as we can, record each dp[i]'s longest palindrome (with dp[i] equals to the length from mid of the palindrome to end of the palindrome)
// analysis -- in step we can ignore lots of duplicate work by the key point mentioned above, we only need to expand the furthest(not longest) palindrome when we need
// 3. end  -- with the help of longest palindrome dp[i], we can decode the init string s's start and end index, thus we output the result
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

// solution 4
class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("~*");
        
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) + "*");
        }
        sb.append('!');
        
        String ss = sb.toString();
        int dp[] = new int[ss.length()];
        
        int furthest = 2;
        int index = 2;
        for (int i = 2; i < dp.length-2; i++) {
            if (dp[2*index-i] + i >= furthest) {
                int r = furthest + 1;
                int l = 2 * i - furthest - 1;
                
                while (ss.charAt(r) == ss.charAt(l)) {
                    r++;
                    l--;
                }
                
                furthest = r - 1;
                index = i;
                dp[i] = furthest - i;
            } else {
                dp[i] = dp[2*index-i];
            }
        }
        
        int m = 0;
        for (int i = 2; i < dp.length-2; i++) {
            if (dp[i] > dp[m]) {
                m = i;
            }
        }
        
        int st = (m - dp[m] - 1) / 2;
        int end = st + dp[m];
        return s.substring(st,end);
    }
}
