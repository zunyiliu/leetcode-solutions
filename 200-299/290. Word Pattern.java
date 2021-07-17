class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap();
        String [] strs = s.split(" ");
        if (strs.length != pattern.length()) return false;
        
        for (int i = 0 ; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(strs[i])) return false;
            } else {
                if (map.containsValue(strs[i])) return false;
                map.put(ch,strs[i]);
            }
        }
        
        return true;
    }
}
