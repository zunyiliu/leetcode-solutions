// solution 1: greedy, in each step find the max length the current pointer can go in the step after the next step, move pointer to 
// the index that will lead to max length
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
