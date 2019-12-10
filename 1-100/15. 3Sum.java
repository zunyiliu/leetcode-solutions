// sort nums[], then loop nums[] each time pick a num[i], and select two pointers low&high moving toward, from i+1 and nums.length-1
// respectively, be aware to consider duplicate situations
// solution 2: same concept, but use hashset so that avoidance of duplicates can be ignored

// solution 1
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            // duplicate situations
            if(i>0 && nums[i]==nums[i-1]) continue;
            int l = i+1;
            int r = nums.length-1;
            
            while(l<r){
                if(nums[l]+nums[r]+nums[i]==0){
                    //duplicate situations
                    if(l==i+1 || nums[l]!=nums[l-1]){
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    }       
                    l++;
                    r--;
                }else if(nums[l]+nums[r]+nums[i]<0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return res;
    }
}

//solution 2
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set= new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            int l = i+1;
            int r = nums.length-1;
            
            while(l<r){
                if(nums[l]+nums[r]+nums[i]==0){
                    set.add(Arrays.asList(nums[i], nums[l], nums[r]));       
                    l++;
                    r--;
                }else if(nums[l]+nums[r]+nums[i]<0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
