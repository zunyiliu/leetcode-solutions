// use swap, swap all 0s to the head and 2s to the end, some logic is a bit complex to deal
class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length-1;
        int cur = 0;
        while(cur<=p2){
            if(nums[cur]==0){
                if(cur==p0) cur++;
                else swap(nums,p0,cur);
                p0++;
            }else if(nums[cur]==2){
                swap(nums,p2,cur);
                p2--;
            }else cur++;
        }
    }
    public void swap(int[] nums,int p0,int i){
        int temp = nums[p0];
        nums[p0] = nums[i];
        nums[i] = temp;
    }
}
