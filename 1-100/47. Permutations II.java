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

//solution 3
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recur(res,nums,0);
        return res;
    }
    public void recur(List<List<Integer>> res,int[] nums,int start){
        if(start == nums.length-1){
            List<Integer> t = new ArrayList<>();
            for(int n:nums) t.add(n);
            res.add(t);
        }else{
            Set<Integer> memo = new HashSet<>();
            for(int i=start;i<nums.length;i++){
                if(memo.add(nums[i])){
                    swap(nums,start,i);
                    recur(res,nums,start+1);
                    swap(nums,start,i); 
                }
            }
        }
    }
    public void swap(int[]nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
