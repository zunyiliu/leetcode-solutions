1. use mind of binary search -- though it runs fast, my solution is wordy, can be simplified in some logic 
2. same way but more simplified

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0 || (nums[0]>target&&nums[nums.length-1]<target) ) return -1;
        return searchIndex(nums,target,0,nums.length-1);
    }
    public int searchIndex(int[] nums,int target,int l,int r){
        if(l>=r){
            if(nums[l]==target) return l;
            return -1;
        }else{
            int mid = (l+r)/2;
            if(nums[l]==nums[mid]){
                if(nums[l] == target) return l;
                if(nums[r] == target) return r;
                return -1;
            }
            //left part of the array
            if(nums[l]<nums[mid]){
                if(nums[l]<=target && target<=nums[mid]){
                    return binarySearch(nums,l,mid,target);
                }else{
                    return searchIndex(nums,target,mid+1,r);
                }
            }else{ // right part of the array
                if(nums[mid]<=target && target<=nums[r]){
                    return binarySearch(nums,mid,r,target);
                }else{
                    return searchIndex(nums,target,l,mid-1);
                }
            }
        }
    }
    public int binarySearch(int[]nums,int l,int r,int target){
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target) return mid;
            
            if(nums[mid]<target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return -1;
    }
}

//solution 2
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]>=nums[l]){
                if(nums[l]<=target && target<=nums[mid]){
                    r = mid;
                }else{
                    l = mid+1;
                }
            }else{
                if(nums[mid]<=target && target<=nums[r]){
                    l = mid;
                }else{
                    r = mid-1;
                }
            }
        }
        if(l==r && target == nums[l]) return l;
        return -1;
    }
}
