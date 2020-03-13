// solution 1: dp, use two dp arrays to store max value and min value
// dpmax[i] stands for the max product of subarray starts from somewhere between index 0 to index i, and ends at index i;
// dpmin[i] stands for the min product of subarray starts from somewhere between index 0 to index i, and ends at index;

// solution 2: same dp concept as solution 1, the optimisation is the status in i is only influenced by the status in i-1
// so, a max and a min that record current index is enough, from the cur min and max we can move forword to the next min and max


// solution 1
class Solution {
    public int maxProduct(int[] nums) {
        int dpmax[] = new int[nums.length];
        int dpmin[] = new int[nums.length];
        dpmax[0] = nums[0];
        dpmin[0] = nums[0];
        
        for(int i=1;i<nums.length;i++){
            int max = Math.max(nums[i]*dpmax[i-1],nums[i]);
            max = Math.max(max,nums[i]*dpmin[i-1]);
            
            int min = Math.min(nums[i]*dpmax[i-1],nums[i]);
            min = Math.min(min,nums[i]*dpmin[i-1]);
            
            dpmax[i] = max;
            dpmin[i] = min;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,dpmax[i]);
        }
        return max;
    }
}

// solution 2
class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], rt = nums[0];
        
        for(int i=1;i<nums.length;i++){
            int a = max;
            int b = min;
            
            max = Math.max(nums[i]*a,nums[i]*b);
            max = Math.max(max,nums[i]);
            
            min = Math.min(nums[i]*a,nums[i]*b);
            min = Math.min(min,nums[i]);

            rt = Math.max(rt,max);
        }
        
        return rt;
    }
}
