// dp : O(n^2)
// set dp = new HashMap[len], where dp[i] stores all arithmetic subsequences that ends at arr[i],
// with differences and corresponding max length recorded in hashmap

class Solution {
    public int longestArithSeqLength(int[] arr) {
        int len = arr.length;
        HashMap<Integer,Integer> dp[] = new HashMap[len];
        int max = 2;
        
        for (int i = 0; i < len; i++) {
            dp[i] = new HashMap();
            
            for (int j = 0; j < i; j++) {
                int diff = arr[i] - arr[j];
                dp[i].put(diff, dp[j].getOrDefault(diff,1) + 1);
                max = Math.max(max,dp[i].get(diff));
            }
        }
        
        return max;
    }
}
