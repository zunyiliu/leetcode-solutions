//same as probelm 46, plus duplicate should be deleted, a general idea is to use hashset to record all permutations
//solution 1: sort nums[] first, while backtracking you can recognize those duplicates
//solution 2: iteration, not efficient since every time should check if the current list has already existed before adding it
//into list
//solution 3: recursively swap

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

//solution 2
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(list.size()==0){
                list.add(new ArrayList<>(Arrays.asList(nums[i])));
            }else{
                List<List<Integer>> tmplist = new ArrayList<>();
                for(int j=0;j<list.size();j++){
                    for(int z=0;z<=list.get(j).size();z++){
                        List<Integer> temp = new ArrayList<>(list.get(j));
                        temp.add(z,nums[i]);
                        if(!tmplist.contains(temp)) tmplist.add(temp);
                    }
                }
                list = tmplist;
            }
        }
        return list;
    }
}
