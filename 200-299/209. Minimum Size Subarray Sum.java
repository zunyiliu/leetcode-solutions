// solution 1: two pointers sliding window O(n)
// a head and a tail, sum the continuously sub-array from head to tail, slide the window and record the min length

// solution 2: solution 1 samplified code 

// solution 3: O(nlogn)，try if length==n exists, if so shrink the length and verify cotinuely, if not expand it, in each turn we take O(n) to verify 
// we can deduct O(k) = O(k/2)+O(n) -->  which is O(nlogn)

// solution 1
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        
        int st = 0;
        int end = 0;
        int sum = nums[st];
        int min = 9999999;
        
        while(st<n){
            if(sum<s){
                end++;
                if(end==n) break;
                sum += nums[end];
            }else{
                min = Math.min(min,end-st+1);
                if(min==1) return 1;
                sum -= nums[st];
                st++;
            }
        }
        
        return min == 9999999? 0:min;
    }
}

// solution 2
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        
        int i = 0;
        int j = 0;
        int sum = 0;
        int min = 9999999;
        
        while (j < nums.length) {
            sum += nums[j];
            j++;
            
            while (sum >= s) {
                sum -= nums[i];
                i++;
                min = Math.min(j-i+1,min);
                
                if (min == 1) return 1;
            }
        }
        
        return min == 9999999? 0:min;
    }
}
