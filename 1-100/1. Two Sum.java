//1. two pass hashmap
//2. one pass hashmap, while putting <K,V> onto map, check if the pair has found(since there must exactly one pair)

//solution 1
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numbers = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            numbers.put(nums[i],i);
        }
        int res[] = new int[2];
        for(int i=0;i<nums.length;i++){
            if( numbers.get(target-nums[i])!=null ){
                res[0] = i;
                res[1] = numbers.get(target-nums[i]);
                if(res[0]!=res[1])
                break;
            }
        }
        return res;
    }
}

//solution 2
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
