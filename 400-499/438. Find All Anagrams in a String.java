// solution 1: brute force

// solution 2: O(n) sliding window, apply a hashmap to record all chars, if a new char in, it will increase its value by 1, and if out will reduce its value by 1.
// 1st -- iterate p, e.g if p = "aabc", then the map will become {{a,-2},{b,-1},{c,-1}} after iteration, that means we need two 'a' in, 1 'b' in and 1 'c' in. 
// at the same time we init a int counter = p.length(), this means the number of correct "in" operations we need to do.
// 2nd -- iterate s, our target is to make hashmap's all keys' values to become 0, each time do "in" operation and "out" operation like a sliding a window, 
// if we do a right operation(that is to make a {key,value} key's value to closer to 0), we make counter--, otherwise we let counter++.
// And each time we find the counter becomes to 0, we record that index as at that time, we have already had an Anagrams 


// solution 1:

// solution 2:
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap();
        List<Integer> list = new ArrayList();
        
        if(s.length()<p.length()) return list;
        
        int count = p.length();
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            if(map.containsKey(ch)) map.put(ch,map.get(ch)-1);  
            else map.put(ch,-1);
        }
        
        for(int i=0;i<s.length();i++){
            char in = s.charAt(i);
            
            if(map.containsKey(in)){
                if(map.get(in)<0) count--;
                else count++;
                map.put(in,map.get(in)+1);
            }else{
                map.put(in,1);
                count++;
            }
            
            int j = i-p.length();
            if(j>=0){
                char out = s.charAt(j);
                if(map.get(out)>0) count--;
                else count++;
                map.put(out,map.get(out)-1);
            }
            
            if(count==0) list.add(j+1);
        }
        
        return list;
    }
}
