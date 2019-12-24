// solution 1: greedy, in each step find the max length the current pointer can go in the step after the next step, move pointer to 
// the index that will lead to max length(my own solution, not very good)
// solution 2: greedy algorithm from the end of the array, moving back forward to see if the pointer can back move to the start 
// of the array, amazing solution
// solution 3: backtracking, not efficient algorithm(will exceed time limit in some cases), but easy to understand
//solution 1
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==0) return true;
        int pos = 0;
        int max = -1;
        while(pos<nums.length-1 && nums[pos]+pos<nums.length-1){
            int cur = pos;
            for(int i=0;i<=nums[cur];i++){
                if(max<cur+i+nums[cur+i]){
                    max = cur+i+nums[cur+i];
                    pos = cur+i;
                }
            }
            max = -1;
            //this line is important -- detecting if the pointer is moving forward
            if(cur == pos) return false;
        }
        return pos>=nums.length-1 || nums[pos]+pos>=nums.length-1;
    }
}

//solution 2
class Solution {
    public boolean canJump(int[] nums) {
        int pointer = nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]+i>=pointer) pointer = i;
        }
        return pointer == 0;
    }
}

// solution 3
class Solution {
    public boolean canJump(int[] nums) {
        return backtrack(nums,0);
    }
    public boolean backtrack(int[] nums,int p){
        if(p>=nums.length-1) return true;
        for(int i=1;i<=nums[p];i++){
            if(backtrack(nums,p+i)) return true;
        }
        return false;
    }
}
