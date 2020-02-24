// solution 1: use map keep track consecutive arrays, for each of the array the length is stored in the 
// leftmost and rightmost boundary

// solution 1 
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        int res = 0;
        // keep track the leftmost of rightmost consecutive sequences length for a map
        // e.g {1,2,3,4,5} then map.get(1) and map.get(5) are both 5
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(!map.containsKey(num)){
                int left = map.containsKey(num-1)? map.get(num-1):0;
                int right = map.containsKey(num+1)? map.get(num+1):0;
                int sum = left+right+1;
                //this step is to make sure num is added
                //so while duplicates are found they wont be re-calculated
                map.put(num,-999);
                map.put(num-left,sum);
                map.put(num+right,sum);
                res = Math.max(res,sum);
            }
        }
        return res;
    }
}
