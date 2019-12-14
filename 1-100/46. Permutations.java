// solution 1: stupid recursion, split nums[] into left part and right part, e.g 123-> 1 and 23, loop right part,
// append new int to left part and call recur(newleft,newright)--- befor-> recur(1,23) after--> recur(12,3) and recur(13,2)

// solution 2: same concept but better optimizations
//solution 3: iteration --iterate all res's element, for each element, try to insert current value into 
// all possible positions of that element, e.g insert 2 in {1}, you will get {1,2} and {2,1}
// for an example [1,2,3], and result List<List> res,
// step 1: res is empty, so just insert 1 into res --> {1}
// step 2: res is {1}, so insert 2 into all positions in {1}, res --> {1,2} and {2,1}
// step 3: res is {1,2} and {2,1}, insert 3 to {1,2} get {3,1,2},{1,3,2} and {1,2,3}, insert 3 to {2,1} get {3,2,1},{2,3,1} and {2,1,3},
// thus overall res --> {3,1,2},{1,3,2},{1,2,3},{3,2,1},{2,3,1},{2,1,3}
// solution 4: swap based recursion

//solution 1
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

//solution 3
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for(int n:nums){
            if(res.size()==0){
                res.add( new ArrayList<>(Arrays.asList(n)) );
            }else{
                List<List<Integer>> newRes = new ArrayList<>();
                for(int i=0;i<res.size();i++){
                    List<Integer> memo = res.get(i);
                    for(int j=0;j<=memo.size();j++){
                        List<Integer> temp = new ArrayList<>(memo);
                        temp.add(j,n);
                        newRes.add(temp);
                    }
                }
                res = newRes;
            }        
        }
        
        return res;
    }
}

// solution 4
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recur(res,nums,0,nums.length-1);
        return res;
    }
    public void recur(List<List<Integer>> res,int[] nums,int st,int end){
        if(st==end){
            List<Integer> temp = new ArrayList<>();
            for(int n:nums) temp.add(n);
            res.add(temp);
        }else{
            for(int i=st;i<=end;i++){
                swap(nums,st,i);
                recur(res,nums,st+1,end);
                swap(nums,i,st);
            }
        }
    }
    public void swap(int[] nums,int a,int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
