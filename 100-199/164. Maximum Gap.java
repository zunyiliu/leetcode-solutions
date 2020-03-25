// solution 1: not linear time complexity, use treeset to sort automatically, trivial

// solution 2: linear time complexity, the basic idea is distribute numbers into bucket, with size of gap = (max-min)/nums.length-1
// then you put numbers into buckets based on their value. It is assured that the largest gap among numbers must between different
// bucket, so for each bucket the relatively large gap = next bucket's min value - this bucket's max, iterate buckets and get the
// largest gap. (The worst case is all the nums are distributed evenly and each bucket holds one value, in this case you've just
// use a traditional bucket sort to sort the value)


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


// solution 2
class Solution {
    public int maximumGap(int[] nums) {
        if(nums==null || nums.length<2) return 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int num:nums){
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        int gap = 1+(max-min)/nums.length;
        Integer bucketMax[] = new Integer[nums.length];
        Integer bucketMin[] = new Integer[nums.length];
        
        for(int i=0;i<nums.length;i++){
            int index = (nums[i]-min)/gap;
            bucketMax[index] = bucketMax[index]==null? nums[i]:Math.max(bucketMax[index],nums[i]);
            bucketMin[index] = bucketMin[index]==null? nums[i]:Math.min(bucketMin[index],nums[i]);
        }
        
        int maxgap = Integer.MIN_VALUE;
        int pre = bucketMax[0];
        for(int i=1;i<nums.length;i++){
            if(bucketMin[i]!=null){
                maxgap = Math.max(maxgap,bucketMin[i]-pre);
                pre = bucketMax[i]; 
            }
        }
        // case while all nums are same and they are all
        // distributed in the same 1st bucket
        return maxgap==Integer.MIN_VALUE? 0:maxgap;
     }
}
