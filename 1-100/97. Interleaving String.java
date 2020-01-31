// solution 1: backtracking, can only pass 99/101 of the test cases(too long input incurs time limit exceeded)
// solution 2: dp

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
