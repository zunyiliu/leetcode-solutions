// solution 1 & 1.1: backtracking same concept but add time different

//olution 1
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        recur(res,new ArrayList(),0,nums);
        res.add(new ArrayList());
        return res;
    }
    public void recur(List<List<Integer>> res,List<Integer> cur,int st,int[] nums){
        if(st<nums.length){
            for(int i=st;i<nums.length;i++){
                if(i==st || nums[i-1]!=nums[i]){
                    cur.add(nums[i]);
                    res.add(new ArrayList(cur));
                    recur(res,cur,i+1,nums);
                    cur.remove(cur.size()-1);
                }
            }
        }
    }
}

//solution 1.1
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        recur(res,new ArrayList(),0,nums);
        return res;
    }
    public void recur(List<List<Integer>> res,List<Integer> cur,int st,int[] nums){
        res.add(new ArrayList(cur));
        if(st<nums.length){
            for(int i=st;i<nums.length;i++){
                if(i==st || nums[i-1]!=nums[i]){
                    cur.add(nums[i]);
                    recur(res,cur,i+1,nums);
                    cur.remove(cur.size()-1);
                }
            }
        }
    }
}
