// dp: use two dp arrays to store max value and min value
// dpmax[i] stands for the max product of subarray starts from somewhere between index 0 to index i, and ends at index i;
// dpmin[i] stands for the min product of subarray starts from somewhere between index 0 to index i, and ends at index;

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
