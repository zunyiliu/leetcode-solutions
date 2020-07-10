// array operation, trivial

class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) nums[i-count] = nums[i];
            else count++;
        }
        for(int i=0;i<count;i++){
            nums[nums.length-1-i] = 0;
        }
    }
}
