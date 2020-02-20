class Solution {
    public boolean isPalindrome(String s) {
        int st = 0;
        int end = s.length()-1;
        s = s.toUpperCase();
        while(st<end){
            if( (s.charAt(st)<65 || s.charAt(st)>90) && (s.charAt(st)-'0'>9)||(s.charAt(st)-'0'<0)){
                st++;
                continue;
            }
            if( (s.charAt(end)<65 || s.charAt(end)>90) && (s.charAt(end)-'0'>9)||(s.charAt(end)-'0'<0)){
                end--;
                continue;
            }
            if(s.charAt(st)==s.charAt(end)){
                st++;
                end--;
                continue;
            }
            return false;
        }
        return true;
    }
}
