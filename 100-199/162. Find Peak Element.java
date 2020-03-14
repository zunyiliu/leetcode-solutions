// binary search, very clear and easy

class Solution {
    public int findPeakElement(int[] nums) {
        int st = 0;
        int end = nums.length-1;
        
        while(st<end){
            int mid = (st+end)/2;
            if(peek(nums,mid)) return mid; 
            if(mid>0 && nums[mid]<nums[mid-1]){
                end = mid-1;
            }else if(mid<nums.length-1 && nums[mid]<nums[mid+1]){
                st = mid+1;
            }
        }
        return st;
    }
    public boolean peek(int[] nums,int mid){
        boolean l = mid==0 || nums[mid]>nums[mid-1];
        boolean r = mid==nums.length-1 || nums[mid]>nums[mid+1];
        return l&&r;
    }
}
