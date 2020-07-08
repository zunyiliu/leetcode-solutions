// solution 1: apply two arrays, left[] and right[], left[i] represents nums[0]*nums[1]*...*nums[i-1],
// right[i] represents nums[i+1]*nums[i+2]*...*nums[nums.length-1], so res[i] = left[i]*right[i]

// solution 1.1: same idea, use in-place meemory so the solution can be within the requirement of the problem(don't create a right[], do operations in left[] and retutn left)

// solution 1
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        left[0] = 1;
        right[right.length-1] = 1;
        
        for(int i=1;i<left.length;i++){
            left[i] = nums[i-1]*left[i-1];
        }
        
        for(int i=right.length-2;i>=0;i--){
            right[i] = nums[i+1]*right[i+1];
        }
        
        int res[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i] = left[i]*right[i];
        }
        return res;
    }   
}

// solution 1.1
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length];
        res[0] = 1;
        
        for(int i=1;i<nums.length;i++){
            res[i] = res[i-1]*nums[i-1];
        }
        
        int right = 1;
        for(int i=nums.length-2;i>=0;i--){
            right = right*nums[i+1];
            res[i] = res[i]*right;
        }
        return res;
    }
}
