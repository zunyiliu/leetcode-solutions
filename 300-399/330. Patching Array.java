// Greedy
// assume x is the number we are verifying, and numbers 1 ~ x-1 are all verified,
// if nums[i] is valid then 1 ~ x-1+nums[i] are all valid, so we let x = x + nums[i]
// if nums[i] is invalid (either nums[i] is bigger then x or i is an exceeded index of nums[]), then
//  we patch a number pat equal to x (as for min patch), and let x = x + pat(where pat is x), that is x *= 2

class Solution {
    public int minPatches(int[] nums, int n) {
        long x = 1;
        int index = 0;
        int count = 0;
        
        while (x <= n) {
            if (index >= nums.length || nums[index] > x) {
                count++;
                x *= 2;
            } else {
                x += nums[index];
                index++;
            }
        }
        
        return count;
    }
}
