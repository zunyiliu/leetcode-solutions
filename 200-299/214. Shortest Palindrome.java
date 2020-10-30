// One scenario, we're acutually looking for a longest palindrome starts from index 0
// once find the longest palindrome, reversely traverse input string from its tail to the end of the longest palindrome
// and append these chars at the head of the string
// --> we can apply dp O(n^2), pointer centre expand method O(n^2), or manachar O(n) to solve longest palindromic substring problem and then solve this problem
// --> also brute force also works O(n^2) as we are only looking for the longest palindrome starts from the head of the input string
// --> !!However, only O(n) solution is acceptable as the input string will contain up to 5 * 10 ^ 4 chars

// solution 1: manacher's algorithm, O(n) time copmplexity, please check explanation in problem 5.longest palindromic substring
class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("~*");
        for (int i = 0; i < s.length(); i++) sb.append(s.charAt(i)+"*");
        sb.append("!");
        
        String ss = sb.toString();
        int dp[] = new int[ss.length()];
        
        int p = 2;
        for (int i = 2; i < ss.length()-2; i++) {
            if (dp[2*p-i] + i >= p + dp[p]) {
                int r = dp[p] + p + 1;
                int l = 2 * i - r;
                
                while (ss.charAt(r) == ss.charAt(l)) {
                    r++;
                    l--;
                }
                
                dp[i] = r - 1 - i;
                p = i;
            } else {
                dp[i] = dp[2*p-i]; 
            }
        }
        
        int longest = 2;
        
        for (int i = 2; i <= ss.length()/2; i++) {
            if (i - dp[i] == 1) longest = i;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = s.length()-1; i >= dp[longest]; i--) {
            result.append(s.charAt(i));
        }
        
        return result.append(s).toString();
    }
}
