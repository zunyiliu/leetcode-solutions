// solution 1: entend from problem 139, will exceed memory limit (it stores all results for all the length of s's substrings)
// solution 2: backtracking DFS with hashmap to store duplicate strings' result

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

// solution 2
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }       

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s)) 
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();     
        if (s.length() == 0) {
            res.add("");
            return res;
        }               
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) 
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
            }
        }       
        map.put(s, res);
        return res;
    }
}
