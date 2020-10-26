// solution 1:
// * read the decription carefully, be sure that 1. a char can only map to one char 2. now two chars can map to a same char *
// set can be avoided as HashMap has an inner function called map.containsValue(value)
// solution 2: same logic, use array instead of map
// solution 3: same but avoid using both set and map, the actual method is to use an array to calculate the occurence of a char which is mapped by others
// if two chars map to a same char then the occurence will become 2, thus return false

// solution 1
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap();
        Set<Character> set = new HashSet();
        if(s.length()!=t.length()) return false;
        
        for(int i=0;i<s.length();i++){
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            
            if(map.containsKey(chs)){
                if(map.get(chs)!=cht) return false;
            }else{
                if(set.contains(cht)) return false;
                map.put(chs,cht);
                set.add(cht);
            }
        }
        
        return true;
    }
}

// solution 2
class Solution {
    public boolean isIsomorphic(String s, String t) {
        char []map = new char[255];
        Set<Character> set = new HashSet();
        if(s.length()!=t.length()) return false;
        
        for(int i=0;i<s.length();i++){
            char ch0 = s.charAt(i);
            char ch1 = t.charAt(i);
            
            if(map[ch0-0]==0){
                if(set.contains(ch1)) return false;
                map[ch0-0] = ch1;
                set.add(ch1);
            }else{
                if(map[ch0-0]!=ch1) return false;
            }
        }
        return true;
    }
}

// solution 3
class Solution {
    public boolean isIsomorphic(String s, String t) {
        char []map = new char[255];
        int []m2 = new int[255];
        if(s.length()!=t.length()) return false;
        
        for(int i=0;i<s.length();i++){
            char ch0 = s.charAt(i);
            char ch1 = t.charAt(i);
            
            if(map[ch0-0]==0){
                if(m2[ch1-0]>0) return false;
                map[ch0-0] = ch1;
                m2[ch1-0]++;
            }else{
                if(map[ch0-0]!=ch1) return false;
            }
        }
        return true;
    }
}
