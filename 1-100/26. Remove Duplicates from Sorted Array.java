 class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int current = 1234567;
        for(int i=0;i<nums.length;i++){
            if(current != nums[i]){
                nums[k] = nums[i];
                current = nums[i];
                k++;
            }    
        }
        return k;
    }
}
