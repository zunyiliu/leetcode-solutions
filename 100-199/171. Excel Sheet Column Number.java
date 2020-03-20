class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        while(s.length()>0){
            sum *= 26;
            sum += s.charAt(0)-'A'+1;
            s = s.substring(1);
        }
        return sum;
    }
}
