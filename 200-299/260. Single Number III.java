// solution1: hashmap
class Solution {
    public int[] singleNumber(int[] nums) {
        int [] res = new int[2];
        Map<Integer,Integer> map = new HashMap();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        boolean first = false;
        for (Integer key : map.keySet()) {
           if (map.get(key) == 1) {
               if (!first) {
                   first = true;
                   res[0] = key;
               } else {
                   res[1] = key;
               }
           }
        }
        
        return res;
    }
}

// solution 2: bit manipulation
