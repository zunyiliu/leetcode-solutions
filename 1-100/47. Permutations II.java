//same as probelm 46, plus duplicate should be deleted, a general idea is to use hashset to record all permutations
//solution 1: sort nums[] first, while backtracking you can recognize those duplicates
//solution 2: iteration

//solution 1
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean record[] = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),nums,record);
        return res;
    }
    public void backtrack(List<List<Integer>> res,List<Integer>templist,int[] nums,boolean []record){
        if(templist.size()==nums.length) res.add(new ArrayList<>(templist));
        else{
            for(int i=0;i<nums.length;i++){
                if(record[i] ||(i>0&&nums[i-1]==nums[i]&&!record[i-1]) ) continue;
                else{
                    record[i] = true;
                    templist.add(nums[i]);
                    backtrack(res,templist,nums,record);
                    record[i] = false;
                    templist.remove(templist.size()-1);
                }
            }
        }
    }
}
