//1. modification of binary search, after finding the target, still go through left and right side's search of target, and keep updating
//the range of index of target
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index[] = {-1,-1};
        int l = 0;
        int r = nums.length-1;
        recur(nums,index,target,l,r);
        return index;
    }
    public void recur(int[] nums,int[] index,int target,int l,int r){
        while(l<=r){
            int mid = (l+r)/2;
            if(target==nums[mid]){
                if(index[0]==-1){
                    index[0] = mid;
                    index[1] = mid;
                }else{
                    if(index[0]>mid){
                        index[0] = mid;
                    }
                    if(index[1]<mid){
                        index[1] = mid;
                    }
                }
                recur(nums,index,target,l,mid-1);
                recur(nums,index,target,mid+1,r);
                break;
            }else if(target>nums[mid]){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
    }
}
