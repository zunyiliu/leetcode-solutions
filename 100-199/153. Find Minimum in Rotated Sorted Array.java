// binary search 

class Solution {
    public int findMin(int[] nums) {
        return recur(nums,0,nums.length-1);
    }
    public int recur(int []nums,int st,int end){
        // stop point while subarray's length is <= 2
        if(st==end) return nums[st];
        if(end-st==1) return Math.min(nums[st],nums[end]);
        
        // binary search
        int mid = (st+end)/2;
        // hit the minimum
        if(nums[mid-1]>nums[mid]) return nums[mid];
        // minimum in right subarray
        if(nums[mid]>nums[end]) return recur(nums,mid+1,end);
        // minimum in left subarray
        return recur(nums,st,mid-1);
    }
}
