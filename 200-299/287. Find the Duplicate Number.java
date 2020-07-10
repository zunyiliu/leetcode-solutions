// solution 1: O(n), Same as findLinkedList Cycle, the sentence "Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive)" shows that there must be a cycle
// use two pointers, fast and slow, fast moves two steps while slow moves one step each time, since there's a cycle it must a time fast meets slow. After fast meets slow, set 
// slow to zero, then move slow and fast one step each time, the time they meet is the start point of the cycle, since we are looking for the duplicate nums, the nums of slow and 
// fast that goes into the start of the cycle is the num that is duplicated

// solution 2: Binary Search O(nlogn)

// solution 1
class Solution {
    public int findDuplicate(int[] nums) {
        int slow =0,fast = 0;
        
        while(true){
            fast = nums[fast];
            fast = nums[fast];
            slow = nums[slow];
            if(fast==slow) break;
        }
        
        slow = 0;
        while(slow!=fast){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
