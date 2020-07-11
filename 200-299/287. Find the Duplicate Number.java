// solution 1: O(n), Same as findLinkedList Cycle, the sentence "Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive)" shows that there must be a cycle
// use two pointers, fast and slow, fast moves two steps while slow moves one step each time, since there's a cycle it must a time fast meets slow. After fast meets slow, set 
// slow to zero, then move slow and fast one step each time, the time they meet is the start point of the cycle, since we are looking for the duplicate nums, the nums of slow and 
// fast that goes into the start of the cycle is the num that is duplicated

// solution 2: Binary Search O(nlogn)
// binary search for the values in array nums[](not binary search the index), "Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive)"  shows
// the one of duplicated nums x must be in index x

// solution 3: O(n) need the input to be writable, the concept is, revert the nums[i] into -num[i], since there're only one num is duplicated
// assume num[i] is duplicated, the 1st you meet num[i], let num[num[i]] = -num[num[i]], then the next time you meet an other num[i], you will 
// find num[num[i]] is negative(that means num[i] is duplicated)

// solution 4: O(32N) time complexity O(1) space, bit operation
// for a given bit (from 0 to 32), count the number of 1s from nums[0] to nums[nums.length-1] and the number of 1s from 1 to nums.length, if the former's 1s is more than
// the latter's 1s, it means the duplicated number has 1 in current bit, do this for all 32-bits and we can concatenate the result bit by bit

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

// solution 2
public class Solution {
    public int findDuplicate(int[] nums) {
        int st = 0;
        int end = nums.length-1;
        
        while(st<end){
            int mid = (st+end)/2;
            
            int count = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=mid) count++;
            }
            
            if(count<=mid) st = mid+1;
            else end = mid;
            
        }
        return st;
    }
}

// solution 3
public class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]);
            if(nums[index]<0) return index;
            nums[index] = -nums[index];
        }
        return -1;
    }
}


// solution 4
public class Solution {
    public int findDuplicate(int[] nums) {
        int res = 0;
        
        for(int i=0;i<32;i++){
            int a = 0,b = 0;
            for(int j=0;j<nums.length;j++){
                int numInBitI = (nums[j]>>i)&1;
                int indexInBitI = (j>>i)&1;
                if( numInBitI == 1) a++;
                if( indexInBitI == 1) b++;
            }
            if(a>b) res |= 1<<i;
        }
        
        return res;
    }
}
