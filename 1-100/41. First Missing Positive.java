class Solution {
    // the first missing num n from a nums[] must 1<=n<=nums.length+1
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            //prevent nums[i] negative, nums[i] exceeds max limit, nums[i] is already in its corresponding index
            if(nums[i]>0 && nums[i]<=nums.length && nums[i]!=i+1){
                //prevent loop forever, like [1,2,1] or [1,2,3,2]--the corresponding num in nums[i] is already been in its index,
                //and nums[i] is a duplicate
                if(nums[i]!=nums[nums[i]-1]){
                    swap(nums,i,nums[i]-1);
                    i--;   
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

