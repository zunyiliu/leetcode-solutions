// solution 1: reduce 4sum to 3sum, 3sum to 2sum, use sorted array two pointers within O(n) to solve 2sum --> 4sum's time complexity is O(n^3)
// for duplicates, use Hashset to avoid that with O(1) while add
// solution 2: can also find all pairs of 4sum, record them on a hashmap<pair,pair's sum>, thus reduce 4sum to 2sum
//solution 1
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> re = new HashSet<List<Integer>>();
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int start = j+1;
                int end = nums.length-1;
                while(start<end){
                    int temp = nums[i]+nums[j]+nums[start]+nums[end];
                    if(temp==target){
                        re.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                        start++;
                        end--;
                    }else if(temp<target){
                        start++;
                    }else{
                        end--;
                    }
                }
            }
        }
        return new ArrayList<>(re);
    }
}
