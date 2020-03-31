// solution 1: naive, O(n^2) time complexity and O(1) extra space
// solution 2: easy to understand, rotate 3 times(the whole array, the first part, the second part)

// solution 1
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length<=1) return;
        while(k>0){
            iteration(nums,k);
            k--;
        }
    }
    public void iteration(int[] nums,int k){
        int tmp = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            nums[i+1] = nums[i];
        }
        nums[0] = tmp;
    }
}

// solution 2
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int nums[],int st,int end){
        while(st<end){
            int temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
    }
}
