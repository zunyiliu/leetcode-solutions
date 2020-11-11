// O(n) solution
// treat the problem as a bucket sort problem
// let the width of each bucket to be t+1
// 1. apply a slide window, with window size == k, slide forward of nums[]
// 2. we add numbers that are within the window and once a number is out of the window, delete that number, here we use a hashMap to maintain the storage
// 3. let the bucket id as nums[i] / bucketSize(that is t+1 ), the storage put the (bucket id, numbers[i]) and there will be two cases
//    a. two buckets with same bucket id --> their absolute difference is definitely at most t, return true
//    b. two buckets are neighbour --> get their number according to bucket id and calculate their absolute difference, return true if is <= t, continue otherwise

// note: as nums[i] is from -2^31 to 2^31-1, we add Integer.MIN_VALUE to nums[i] before calculating its bucket id 
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0) return false;
        Map<Long, Long> map = new HashMap<>();
        
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            long cur = ((long)nums[i] - (long)Integer.MIN_VALUE);
            long bucket = cur / ((long)t + 1);
            
            if (map.containsKey(bucket)) return true;
            if (map.containsKey(bucket+1)) {
                if (map.get(bucket+1) - nums[i] <= t) return true;
            }
            if (map.containsKey(bucket-1)) {
                long tmp = map.get(bucket-1);
                if (nums[i] - map.get(bucket-1) <= t) return true;
            }
            map.put(bucket,(long)nums[i]);
            
            if (count == k) { 
                map.remove(((long)nums[i-k] - (long)Integer.MIN_VALUE) / ((long)t + 1) );
            } else {
                count++;
            }
        }
        
        return false;
    }
}
