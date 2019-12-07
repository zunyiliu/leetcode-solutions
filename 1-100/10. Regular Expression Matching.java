// 1. recursively backtracking and return the result
// 2. add dynamic programming to increase execution speed

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
