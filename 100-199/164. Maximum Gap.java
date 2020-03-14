// solution 1: not linear time complexity, use treeset to sort automatically, trivial


// solution 1
class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<=1) return 0;
        int gap = Integer.MIN_VALUE;
        Set<Integer> set = new TreeSet();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])) gap = 0;
            set.add(nums[i]);
        }
        Integer pre = null;
        for(Integer num:set){
            if(pre!=null){
                gap = Math.max(num-pre,gap);
            } 
            pre = num;
        }
        return gap;
    }
}
