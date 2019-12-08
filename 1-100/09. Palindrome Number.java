// solution 1: easy-- revert the int and check if they are equal
// solution 2: only revert half of the int and check if left part and right part are equal, more edge cases should be considered

// solution 1
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int origin = x;
        int re = 0;
        while(x!=0){
            re *= 10;
            re += x%10;
            x /= 10;
        }
        return re==origin;
    }
}

//solution 2
class Solution {
    public boolean isPalindrome(int x) {
        // prevent case like 50, 100 etc
        if(x<0 || (x%10==0 && x!=0)) return false;
        int re = 0;
        while(x>re){
            re *= 10;
            re += x%10;
            x /= 10;
        }
        return re==x || re/10==x;
    }
}
