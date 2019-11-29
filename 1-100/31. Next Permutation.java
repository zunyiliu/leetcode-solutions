// 1. solution: your goal is to find the next larger permutation number of the current number(just a bit larger than it, means there's no
// other permutations can exist between these two numbers). The mind behind the solution is: you start from the end of the number, assume it
// is descending sorted, if you go through all the list and find it's totally descended, then reverse the whole list(to get the smallest one).
// Else, the number which firstly breaches descending sequence will be selected, and it will exchange with the number in the list of scanned
// numbers that is just a one step bigger than itself, after exchanging the scanned list of course will still be descending sorted, then you
// reverse the descending sorted scanned list.
// E.G. 548632 --> first breached descending sequence's number is 4 --> go through scanned list 8632, find 6 wich is just bit larger than 4
// --> exchange 4 with 6 to get 568432, reverse 8432 to get 562348 --> done!!

class Solution {
    public void nextPermutation(int[] nums) {
        int val = -999999;
        int pointer = nums.length-1;
        int pointer1 = 0;
        //start from tail, find the first num that breaches descending order
        loop:
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>=val){
                val = nums[i];
            }else{
                for(int j=nums.length-1;j>i;j--){
                    if(nums[j]>nums[i]){
                        pointer = i;
                        pointer1 = j;
                        break loop;
                    }
                }
            }
        }
        //the array is descending sorted already, reverse whole array
        if(pointer == nums.length-1){
            reverse(nums,0,nums.length-1);
        }else{ //exchange the pointer pointing to the 1st breach num with the tail
            int temp = nums[pointer];
            nums[pointer] = nums[pointer1]; 
            nums[pointer1] = temp;
            reverse(nums,pointer+1,nums.length-1);
        }
    }
    public void reverse(int[] nums,int start,int end){
        for(int i=start;i<=(start+end)/2;i++){
            int temp = nums[i];
            nums[i] = nums[start+end-i];
            nums[start+end-i] = temp;
        }
    }
}
