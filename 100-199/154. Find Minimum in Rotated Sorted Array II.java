// O(n*logn) in average case 
class Solution {
    public int findMin(int[] nums) {
        int st = 0, end = nums.length-1;
        while(st<end){
            int mid = (st+end)/2;
            if(nums[mid]<nums[end]){
                end = mid;
            }else if(nums[mid]>nums[end]){
                st = mid+1;
            }else{
                end--;
            }
        }
        return nums[st];
    }
}
