// solution 1 -- backtrack
// solution 2 -- iteration
// solution 3 -- Lexicographic (Binary Sorted) Subsets -- from leetcode solution

// solution 1
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        backtrack(res,new ArrayList(),nums,0);
        return res;
    }
    public void backtrack(List<List<Integer>> res,List<Integer> list,int[] nums,int start){
        res.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(res,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}

// solution 2
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());
        for(int i=0;i<nums.length;i++){
            List<List<Integer>> newres = new ArrayList();
            for(int j=0;j<res.size();j++){
                List<Integer> t = new ArrayList<>(res.get(j));
                t.add(nums[i]);
                newres.add(t);
            }
            res.addAll(newres);
        }
        return res;
    }
}

// solution 3
