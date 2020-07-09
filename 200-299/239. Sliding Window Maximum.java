// the brute-force method is trivial, won't mention here
// solution 1: Apply PriorityQueue, time complexity O(n*K) (since remove takes O(k) in built-in Java priorityquque.remove())
// if we implement remove ourselves, it will take O(n*logK)

// solution 2: use the mind of deque, since remove in LinkedList also takes O(1), so use linkedlist also works
// The concept is -- The LinkedList is storing elements from nums[] with their index sequence, 
// basically for the nums[i] we are about to insert, first we move the leftmost element from linkedlist if it's out of window bound, then,
// we continuously delete those rightmost elements in that are smaller than nums[i] 

// solution 3: Deque 
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

// solution 2
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new LinkedList();
        int res[] = new int[nums.length-k+1];
        
        for(int i=0;i<nums.length;i++){
            if(list.size()>0 && list.get(0)<=i-k) list.remove(0);
            
            while(list.size()>0 && nums[i]>nums[list.get(list.size()-1)] ){
                list.remove(list.size()-1);
            }
            list.add(i);
            if(i-k+1>=0) res[i-k+1] = nums[list.get(0)];
        }
        
        return res;
    }
}
