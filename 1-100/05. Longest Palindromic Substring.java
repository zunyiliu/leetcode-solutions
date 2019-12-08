// solution 1 O(n^2), loop s, each time expand around s.charAt(i) and record start&end index if palindrome is longer than before
// 2：can also be solved by using dp
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
