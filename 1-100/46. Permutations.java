// solution 1: stupid recursion, split nums[] into left part and right part, e.g 123-> 1 and 23, loop right part,
// append new int to left part and call recur(newleft,newright)--- befor-> recur(1,23) after--> recur(12,3) and recur(13,2)

// solution 2: same concept but better optimizations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> t = new HashSet<Integer>();
        for(int i:nums) t.add(i);
        backtrack(new ArrayList<Integer>(),t,res);
        return res;
    }
    public void backtrack(List<Integer> memo,Set<Integer> t,List<List<Integer>> res){
        if(t.size()==0){
            res.add(memo);
        }else{
            for(int num:t){
                List<Integer> newmemo = new ArrayList<>(memo);
                newmemo.add(num);
                Set<Integer> newset = new HashSet<>(t);
                newset.remove(num);
                backtrack(newmemo,newset,res);
            }
        }
    }
}

//solution 2
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean []record = new boolean[nums.length];
        backtrack(new ArrayList<>(),record,nums,res);
        return res;
    }
    public void backtrack(List<Integer> memo,boolean []record,int[] nums,List<List<Integer>> res){
        if(memo.size()==nums.length) res.add(new ArrayList<>(memo));
        for(int i=0;i<nums.length;i++){
            if(!record[i]){
                record[i] = true;
                memo.add(nums[i]);
                
                backtrack(memo,record,nums,res);
                
                record[i] = false;
                memo.remove(memo.size()-1);
            }
        }
    }
}
