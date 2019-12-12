//solution 1: greedy, each step find the farthest one the next step after this step is selected, till reach the end and return the 
//total count of steps used
//solution 2: more concisely than 1st soltuon, solution 1 is intuitive whereas 2 is way more beautiful

//solution 1
class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int index = 0;
        while(index<nums.length-1){
            if(index+nums[index]>=nums.length-1) return count+1;
            int max = 0;
            int next_jump = 0;
            for(int i=1;i<=nums[index];i++){
                if(nums[i+index]+i>max){
                    max = nums[i+index]+i;
                    next_jump = i;
                }
            }
            index += next_jump;
            count++;
        }
        return count;
    }
}

//solution 2
class Solution {
    public int jump(int[] A) {
	int jumps = 0, curEnd = 0, curFarthest = 0;
	for (int i = 0; i < A.length - 1; i++) {
		curFarthest = Math.max(curFarthest, i + A[i]);
		if (i == curEnd) {
			jumps++;
			curEnd = curFarthest;
		}
	}
	return jumps;
    }
}
