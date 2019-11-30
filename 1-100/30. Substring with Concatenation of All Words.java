1. HashMap, use hashmap to record each word with its frequency, loop s and check each substring of s is a concatenation of words[],
if so save that index.

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length==0) return res;
        int max = words.length * words[0].length();
        
        HashMap<String,Integer> mapping = new HashMap<String,Integer>();
        for(int i=0;i<words.length;i++)
            mapping.put(words[i], mapping.containsKey(words[i])? mapping.get(words[i])+1:1);
        
        for(int i=0;i<s.length()-max+1;i++){
            if( check(s.substring(i,max+i),words,mapping) ) res.add(i);
        }
        return res;
    }
    public boolean check(String s, String[] words,HashMap<String,Integer> mapping){
        int n = words.length;
        int len = words[0].length();
        HashMap<String,Integer> copy = new HashMap<String,Integer>(mapping);
        
        for(int i=0;i<n;i++){
            String temp = s.substring(i*len,i*len+len);
            if(copy.get(temp)==null){
                return false;
            }else{
                if(copy.get(temp)==1) copy.remove(temp);
                else copy.put(temp,copy.get(temp)-1);
            }
        }
        
        if(copy.isEmpty()) return true;
        return false;
    } 
}
