// solution 1: dp O(n^2), init array dp[], dp[i] represents the longest length of increasing subsequence ends in nums[i], 
// dp[i] = max of dp[j] + 1 (where nums[j] < nums[i] and j is between 0 and i-1)

// solution 2: binary search O(nlogn), we maintain a optimized array that keep track of the longest increasing subsequence
// the binary search is for finding the corresponding position for a given num and the array
// e.g for a given array [10,9,2,5,3,7,1,4], the iteration is as follows:
// 10
// 9 < 10 so --> 9
// 2 < 9 so --> 2
// 5 > 2, append 5 at the end of the array --> 2,5
// 7 > 5 --> 2,5,7
// 1 is smaller than the smallest element in [2,5,7], update 1 in its corresponding position --> 1,5,7
// update 4 in its corresponding position --> 1,4,7
// the keep concept is that the array you're maintaining is not the real subsequence, however it has the correct length
// while updating a new num into the array, we are updating a potentially longest subsequence in the future
// that's say [2,5,7] and the new num is 1, even though we update the array to [1,5,7], since 7 is the threshold, when there's
// a bigger num comes we can add it to the end of the array, and not influencing the result

// solution 1
class Solution {
    public int lengthOfLIS(int[] nums) {
        int []dp = new int[nums.length];
        int max = 0;
        
        for(int i=0;i<nums.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}

// solution 2
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList();
        
        for(int i=0;i<nums.length;i++){
            int index = Collections.binarySearch(list,nums[i]);
            if(index<0) index = -index-1;
            
            if(index==list.size()) list.add(nums[i]);
            else list.set(index,nums[i]);
        }
        
        return list.size();
    }
}
