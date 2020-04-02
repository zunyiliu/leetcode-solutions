// solution 1: naive, O(n^2) time complexity and O(1) extra space
// solution 2: easy to understand, rotate 3 times(the whole array, the first part, the second part)
// solution 3: Reverse part of the array -- e.g. [1,2,3,4,5] k = 2, you can reverse k(or array.length-k) position to
// get [4,5,3,1,2], now k is still 2, and array range becomes [3,1,2], then the array is shorten, from doing this iteratively
// the array will be gradually dealt

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

// solution 3
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int st = 0;
        int end = nums.length-1;
        
        while(end>st && k>0){
            int len = end-st+1;
            if(k>=(len+1)/2){
                change(nums,len-k,st,end);
                end -= len-k;
                k -= len-k;
            }else{
                change(nums,k,st,end);
                st += k;
            }
        }
    }
    
    public void change(int nums[],int k,int st,int end){
        while(k>0){
            k--;
            int temp = nums[st+k];
            nums[st+k] = nums[end];
            nums[end] = temp;
            end--;
        }
    }
}
