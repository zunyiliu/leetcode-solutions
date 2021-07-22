// solution 1: brute force

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList();
        
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length-1) res.add(0);
            else {
                int count = 0;
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] < nums[i]) count++;
                }
                res.add(count);
            }
        }
        
        return res;
    }
}
