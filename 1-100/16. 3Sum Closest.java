// two pointers, each iterate of nums[] select a num, thus target becomes target-nums[i], and reduce 3 sum to 2 sum
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int dis = 9999;
        int result = 0;
        
        for(int i=0;i<nums.length-2;i++){
            
            int l = i+1;
            int r = nums.length-1;
            
            while(l<r){
                int temp = nums[i]+nums[l]+nums[r]-target;
                if(temp==0){
                    return target;
                }
                if(temp>0){
                    if(dis>temp){
                        dis = temp;
                        result = temp+target;
                    }
                    r--;
                }else{
                    if(dis>-temp){
                        dis = -temp;
                        result = temp+target;
                    }
                    l++;
                }
            }
        }
        return result;
    }
}
