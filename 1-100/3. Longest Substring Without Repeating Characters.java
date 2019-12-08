// solution 1:brute force with hashtable O(n^2)
// solution 2: sliding window with hashtable O(2n)
// solution 3: using hashmap to optimize sliding windwo (when a duplicate is found, don't need to skip one step once)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                }else{
                    max = Math.max(max,set.size());
                    set.clear();
                    break;
                }
            }
        }
        
        return Math.max(max,set.size());
    }
}

//solution 2
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0,l=0,r=0;
        while(r<s.length() && l<s.length()){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
            }else{
                max = Math.max(max,set.size());
                set.remove(s.charAt(l));
                l++;
            }
        }
        
        return Math.max(max,set.size());
    }
}

//solution 3
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int max = 0,i = 0,j = 0;
        
        while(j<s.length()){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                if(map.get(c)>=i){
                    i = map.get(c)+1;
                }
            }
            map.put(c,j);
            max = Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
