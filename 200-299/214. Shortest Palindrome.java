// One scenario, we're acutually looking for a longest palindrome starts from index 0
// once find the longest palindrome, reversely traverse input string from its tail to the end of the longest palindrome
// and append these chars at the head of the string
// --> we can apply dp O(n^2), pointer centre expand method O(n^2), or manachar O(n) to solve longest palindromic substring problem and then solve this problem
// --> also brute force also works O(n^2) as we are only looking for the longest palindrome starts from the head of the input string
// --> !!However, only O(n) solution is acceptable as the input string will contain up to 5 * 10 ^ 4 chars

// solution 1: manacher algorithm

// solution 2: KMP utilization to solve this problem
// 1. the goal of the problem is to find the longest palindrome starts from index 0 for input string s
// 2. assume s = s1 + s2, s1 is the longest palindrome we are looking for
// 3. init a new string ss = s + "#" + s.reverse(), which is s1 + s2 + '#' + s2.reverse() + s1.reverse()
// 4. since s1 is a palindrome, then s1 == s1.reverse(), the "#" is for preventing the s.reverse() cross the border when expanding (e.g. when s = "aaaaa")
// 5. now we are looking for the KMP look-up table t[ss.length()-1] in ss
// 6. reminder: a KMP look-up table t[i] means the longest same prefix and postfix ending at index i(the prefix starts from head+1, and postfix ends at tail-1)

// solution 2.1: same as 2, use recursion instead of while loop for creating KMP lool-up table

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

// solution 2
class Solution {
    // KMP look up table -- find longest prefix and postfix
    public String shortestPalindrome(String s) {
        String ss = s + "#" + new StringBuilder(s).reverse().toString();
        int table[] = new int[ss.length()];
        
        for (int i = 1; i < ss.length(); i++) {
            if (ss.charAt(table[i-1]) == ss.charAt(i)) table[i] = table[i-1] + 1;
            else {
                int index = table[i-1];
                
                while (index > 0 && ss.charAt(index) != ss.charAt(i)) {
                    index = table[index-1];
                }
                
                if (ss.charAt(index) == ss.charAt(i)) {
                    table[i] = index + 1;
                }
            }
        }
        
        int longest = table[table.length-1];
        return new StringBuilder(s.substring(longest)).reverse().toString() + s;
    }
}

// solution 2.1
class Solution {
    // KMP look up table -- find longest prefix and postfix
    public String shortestPalindrome(String s) {
        String ss = s + "#" + new StringBuilder(s).reverse().toString();
        int t[] = new int[ss.length()];
        
        for (int i = 1; i < t.length; i++) {
            if (ss.charAt(t[i-1]) == ss.charAt(i)) {
                t[i] = t[i-1] + 1;
            } else {
                t[i] = recur(ss,t[i-1],ss.charAt(i),t);
            }
        }
        
        String addon = new StringBuilder(s.substring(t[t.length-1])).reverse().toString();
        return addon + s;
    }
    
    public int recur(String ss, int i, char ch, int[] t) {
        if (i == 0) return ss.charAt(i) == ch? 1 : 0;
        if(ss.charAt(i) == ch) return i + 1;
        return recur(ss,t[i-1],ch,t);
    }
}
