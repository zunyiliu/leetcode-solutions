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

// solution 2: bit manipulation, get the last set bit (the last bit of the two different numbers' that are different), seperate the nums into two groups
class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        
        // get the last set bit of diff
        diff &= -diff;
        
        int res[] = {0,0};
        
        for (int num : nums) {
            if ((num&diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        
        return res;
    }
}
