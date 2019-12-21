//O(n) solution 1: use a pointer to move forward the array, each time record the maximum value of the subarray, sum stands for
// the previous array that contribute positive result(add up the max value), if sum<0, that means the previous array should no longer
// be used, thus the subarray should be re-calculated from the next pointer


// solution 1:
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int cur=0;
        int sum = 0;
        int max = nums[0];
        while(cur<nums.length){
            sum += nums[cur];
            max = Math.max(max,sum);
            if(sum<0) sum = 0;
            cur++;
        }
        return max;
    }
}
