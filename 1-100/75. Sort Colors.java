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

//solution 2: more clear code
class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length-1;
        for(int i=0;i<=p2;i++){
            if(nums[i]==0){
                swap(nums,i,p0);
                p0++;
            }else if(nums[i]==2){
                swap(nums,i,p2);
                p2--;
                i--;
            }
        }
    }
    public void swap(int[] nums,int p0,int i){
        int temp = nums[p0];
        nums[p0] = nums[i];
        nums[i] = temp;
    }
}
