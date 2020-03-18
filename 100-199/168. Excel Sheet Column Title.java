// a bit confused, 'A'-'Z' represents 1-26
// so every time need n-- cause if the base is 26 then it should be 0-25

class Solution {
    public String convertToTitle(int n) {
        String str = "";
        while(n>0){
            n--;
            str = (char)(n%26+'A')+str;
            n /= 26;
        }
        return str;
    }
}
