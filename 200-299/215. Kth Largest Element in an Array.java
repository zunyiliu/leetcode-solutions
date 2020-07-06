// QuickSelect, the idea: select a pivot, partitioning the array into two, with left elements greater than the pivot and right elements
// smaller than the pivot, by doing this you can drop half of the array in each step.
// Note: 1. can apply a randomized strategy so that the time complexity will be O(n) not avg O(n)
// 2. the solution below can import low, high index pointers so you do not need to split and copy elements from the array, just do these in-place, and can save run time
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int pivot = nums[0];
        List<Integer> l = new ArrayList();
        List<Integer> r = new ArrayList();
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]>=pivot){
                l.add(nums[i]);
            }else r.add(nums[i]);    
        }
        
        if(k==l.size()+1) return pivot;
        else if(k<l.size()+1){
            int [] lnew = new int[l.size()];
            for(int i=0;i<l.size();i++) lnew[i] = l.get(i);
            return findKthLargest(lnew,k);
        }else{
            int [] rnew = new int[r.size()];
            for(int i=0;i<r.size();i++) rnew[i] = r.get(i);
            return findKthLargest(rnew,k-l.size()-1);
        }
    }
}
