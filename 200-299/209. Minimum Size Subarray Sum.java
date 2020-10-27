// solution 1: two pointers sliding window
// a head and a tail, sum the continuously sub-array from head to tail, slide the window and record the min length

// solution 1
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        
        int st = 0;
        int end = 0;
        int sum = nums[st];
        int min = 9999999;
        
        while(st<n){
            if(sum<s){
                end++;
                if(end==n) break;
                sum += nums[end];
            }else{
                min = Math.min(min,end-st+1);
                if(min==1) return 1;
                sum -= nums[st];
                st++;
            }
        }
        
        return min == 9999999? 0:min;
    }
}
