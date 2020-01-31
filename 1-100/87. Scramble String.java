// solution 1: recursion, there's misunderstand of this problem, the key is that u can only exchange child nodes under a given binary
// tree structure, that is, "abcde", once u build a tree, u can't exchange two children of a node to get a new string then use the new
// string to build another tree. Which is forbidden

class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length()!=s2.length()) return false;
        int letters[] = new int[26];
        for(int i=0;i<s1.length();i++){
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<letters.length;i++){
            if(letters[i]!=0) return false;
        }
        for(int i=0;i<s1.length()-1;i++){
            if(isScramble(s1.substring(0,i+1),s2.substring(0,i+1)) 
               && isScramble(s1.substring(i+1),s2.substring(i+1))) return true;
            int len = s1.length();
            if(isScramble(s1.substring(0,i+1),s2.substring(len-i-1,len))
               && isScramble(s1.substring(i+1,len),s2.substring(0,len-i-1))) return true;
        }
        return false;
    }
}
