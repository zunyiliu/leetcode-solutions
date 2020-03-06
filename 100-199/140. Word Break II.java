// solution 1: entend from problem 139, will exceed time limit
// solution 2: backtracking

// solution 1
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // dp[len] -- s's substring starts from head with length len is breakword or not 
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        List<String> sentence[] = new ArrayList[s.length()+1];
        for(int i=0;i<sentence.length;i++) sentence[i] = new ArrayList();
        
        for(int len=1;len<dp.length;len++){
            for(String str:wordDict){
                if(str.length()<=len){
                    if(dp[len-str.length()] && s.substring(len-str.length(),len).equals(str)){
                        dp[len] = true;
                        if(len==str.length()) sentence[len].add(str);
                        else{
                            for(int i=0;i<sentence[len-str.length()].size();i++)
                                sentence[len].add(sentence[len-str.length()].get(i)+" "+str);
                        }
                    }
                }
            }
        }
        return sentence[s.length()];
    }
}
