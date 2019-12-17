//utilization of map, easy understanding
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List> map = new HashMap();
        for(int i=0;i<strs.length;i++){
            char schar[] = strs[i].toCharArray();
            Arrays.sort(schar);
            String key = String.valueOf(schar);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return new ArrayList(map.values());
    }
}
