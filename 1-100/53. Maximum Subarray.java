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
