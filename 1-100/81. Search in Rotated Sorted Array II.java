// binary search,a bit tricky seriously, u should figure out all scenarios to be very clear, a draft will be helpful
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = (start+end)/2;
            if(target==nums[mid]) return true;
            else if(target<nums[mid]){
                if(nums[mid]>nums[end] && target<=nums[end]){
                    start = mid+1;
                }else if(nums[mid]==nums[end]){
                    end--;
                }else{
                    end = mid-1;
                }
            }else{
                if(nums[mid]<nums[start] && target>=nums[start]){
                    end = mid-1;
                }else if(nums[mid]==nums[start]){
                    start++;
                }else{
                    start = mid+1;
                }
            }
        }
        return nums[start] == target? true:false;
    }
}
