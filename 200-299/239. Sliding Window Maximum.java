// the brute-force method is trivial, won't mention here
// solution 1: Apply PriorityQueue, time complexity O(n*K) (since remove takes O(k) in built-in Java priorityquque.remove())
// if we implement remove ourselves, it will take O(n*logK)
// solution 2: Deque 
// solution 3: DP with two arrays
// solution 4: 

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((i0,i1)->(nums[i1]-nums[i0]));
        int res[] = new int[nums.length-k+1];
        
        for(int i=0;i<k;i++){
            queue.add(i);
        }
        res[0] = nums[queue.peek()];
        
        for(int i=1;i<res.length;i++){
            queue.remove(i-1);
            queue.add(i+k-1);
            res[i] = nums[queue.peek()];
        }
        
        return res;
    }
}
