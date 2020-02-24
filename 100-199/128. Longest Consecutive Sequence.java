// solution 1: use map keep track consecutive arrays, for each of the array the length is stored in the 
// leftmost and rightmost boundary
// solution 2: use set, O(2n) time complexity, for each num expand its longest length and delete those nums in the current path
// solution 3: use union find algorithm

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

// solution 2
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int n:nums) set.add(n);
        int max = 0;
        for(int n:set){
            if(!set.contains(n+1)){
                int count = 0;
                while(set.contains(n)){
                    n = n-1;
                    count++;
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }
}
