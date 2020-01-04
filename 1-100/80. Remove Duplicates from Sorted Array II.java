// using two pointers, 1st pointer for scanning the list, 2nd for recording the position of array that have no duplicates
// this solution is tough(though problem not, the issue stilll commonly require 30 lines of code to write)
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2) return nums.length;
        int i = 2;
        for(int j=2;j<nums.length;j++){
            if(nums[j]!=nums[i-2]){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
