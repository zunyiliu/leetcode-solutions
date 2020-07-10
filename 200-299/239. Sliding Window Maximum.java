// the brute-force method is trivial, won't mention here
// solution 1: Apply PriorityQueue, time complexity O(n*K) (since remove takes O(k) in built-in Java priorityquque.remove())
// if we implement remove ourselves, it will take O(n*logK)

// solution 2: use the mind of deque, since remove in LinkedList also takes O(1), so use linkedlist also complete the alg in O(n) time
// The concept is -- The LinkedList is storing elements from nums[] with their indices, 
// basically, for the nums[i] we are about to insert, first we remove the leftmost element from linkedlist if it's out of window bound, then,
// we continuously delete those rightmost elements that are smaller than nums[i](since these elements won't influence the sliding window maximum)
// after that insert nums[i] into linkedlist. Last but not least, update res[i-k+1]'s value

// solution 2.1: same as 2, use Deque instead of linkedlist

// solution 3: DP or applying two arrays. Partitioning nums[] into blocks with size k,
// e.g if nums[] = {1,2,3,4,5,6,7,8} and k = 3, then nums[] should be partitioned to 1,2,3; 4,5,6 ; 7,8
// Left[i] represents the max value from the start index of i's block to itself, right[i] represents the max value from the end index of i's block to itself
// we can know that res[i] = Math.max(right[i],left[i+k-1])

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

// solution 2.1
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d= new ArrayDeque();
        int res[] = new int[nums.length-k+1];
        
        for(int i=0;i<nums.length;i++){
            if(!d.isEmpty() && d.peekFirst()<=i-k) d.pollFirst();
            
            while(!d.isEmpty()&& nums[i]>nums[d.peekLast()] ){
                d.pollLast();
            }
            d.offerLast(i);
            if(i-k+1>=0) res[i-k+1] = nums[d.peekFirst()];
        }
        
        return res;
    }
}

// solution 3
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int right[] = new int[n];
        int left[] = new int[n];
        int res[] = new int[n-k+1];
        
        
        for(int i=0;i<n;i++){
            if(i%k==0) left[i] = nums[i];
            else left[i] = Math.max(left[i-1],nums[i]);
        }
        
        for(int i=n-1;i>=0;i--){
            if(i==n-1 || (i+1)%k==0 ) right[i] = nums[i];
            else right[i] = Math.max(right[i+1],nums[i]);
        }
        
        for(int i=0;i<res.length;i++){
            res[i] = Math.max(right[i],left[i+k-1]);            
        }
        
        return res;
    }
}
